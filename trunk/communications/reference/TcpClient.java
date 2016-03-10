package atm.comm.reference;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;

import java.net.Socket;
import java.net.UnknownHostException;

/**
 * This is the client for a chat application.
 * It provides an example for exchanging data between two end points
 * The Socket class is the TCP implementation.
 * This implementation supports multiple client connections, similar to how
 * a full ATM system might need to be implemented to allow multiple ATMs
 * to communicate with the bank server.
 * 
 * @author scottl
 *
 */
public class TcpClient
{
	/**
	 * Read in a nickname from stdin and attempt to authenticate with the server
	 * by sending a NICK command to @out. If the response from @in is not equal
	 * to "OK" go back and read a nickname again
	 * 
	 * @param in BufferedReader reference
	 * @param out The output stream.
	 */
	private static String getNick(BufferedReader in, PrintWriter out)
			throws IOException
	{
		System.out.print("Enter your nick: ");
		String msg = m_stdIn.readLine();
		out.println("NICK " + msg);
		String serverResponse = in.readLine();
		if("SERVER: OK".equals(serverResponse))
			return msg;
		System.out.println(serverResponse);
		return getNick(in, out);
	}

	/**
	 * Entry point for the class.
	 * This example puts a lot of code in the main. Suggest refactoring if you use
	 * this as a starting point and NOT having it in main.
	 * @param args command line arguments
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException
	{

		Socket server = null;

		try
		{
			server = new Socket(m_host, m_port);
		}
		catch(UnknownHostException e)
		{
			System.err.println(e);
			System.exit(1);
		}

		m_stdIn = new BufferedReader(new InputStreamReader(System.in));

		/* obtain an output stream to the server... */
		PrintWriter out = new PrintWriter(server.getOutputStream(), true);
		/* ... and an input stream */
		BufferedReader in = new BufferedReader(new InputStreamReader(
				server.getInputStream()));

		m_nick = getNick(in, out);

		/* create a thread to asynchronously read messages from the server */
		ServerConn sc = new ServerConn(server);
		Thread t = new Thread(sc);
		t.start();

		String msg;
		/* loop reading messages from stdin and sending them to the server */
		while((msg = m_stdIn.readLine()) != null)
		{
			out.println(msg);
		}
	}
	
	// Private data
	private static int m_port = 1001; /* port to connect to */
	private static String m_host = "localhost"; /* host to connect to */

	private static BufferedReader m_stdIn;

	private static String m_nick;
}

class ServerConn implements Runnable
{
	private BufferedReader in = null;

	public ServerConn(Socket server) throws IOException
	{
		/* obtain an input stream from the server */
		in = new BufferedReader(new InputStreamReader(server.getInputStream()));
	}

	public void run()
	{
		String msg;
		try
		{
			/*
			 * loop reading messages from the server and show them on stdout
			 */
			while((msg = in.readLine()) != null)
			{
				System.out.println(msg);
			}
		}
		catch(IOException e)
		{
			System.err.println(e);
		}
	}
}