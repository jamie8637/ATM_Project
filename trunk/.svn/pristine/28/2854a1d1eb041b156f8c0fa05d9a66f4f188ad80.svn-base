package fromBusinesTeam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author mwilson
 */
public class TcpClient {

	private BufferedReader reader;
	private PrintWriter writer;
	private Socket socket;

	public TcpClient(String tcpHost, int tcpPort) throws UnknownHostException,
			IOException {

		socket = new Socket(tcpHost, tcpPort);

		reader = new BufferedReader(new InputStreamReader(
				socket.getInputStream()));
		writer = new PrintWriter(new OutputStreamWriter(
				socket.getOutputStream()), true);

	}

	public String submitRequest(String request) throws IOException {
		writer.println(request);
		return reader.readLine();
	}
	
	public boolean isConnected() {
		return socket.isClosed();
	}

	public void disconnect() {
		try {
			socket.close();
		} catch (Exception ex) {
			//Consume error, we don't care, were closing the connection
		}
	}

}
