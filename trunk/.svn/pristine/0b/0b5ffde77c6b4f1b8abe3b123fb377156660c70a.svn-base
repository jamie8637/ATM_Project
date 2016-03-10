package fromBusinesTeam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

/**
 * @author mwilson
 */
class ClientHandler implements Runnable {

	private Socket socket;
	private BufferedReader reader;
	private PrintWriter writer;
	private RequestProcessor requestProcessor;

	public ClientHandler(Socket socket, RequestProcessor requestProcessor)
			throws IOException {
		this.socket = socket;

		reader = new BufferedReader(new InputStreamReader(
				socket.getInputStream()));
		writer = new PrintWriter(new OutputStreamWriter(
				socket.getOutputStream()), true);

		this.requestProcessor = requestProcessor;
	}

	public void run() {
		while (true) {
			try {
				writer.println(requestProcessor.createResponse(reader
						.readLine()));
			} catch (SocketException e) {
				System.err.println("client disconnected");
				return;
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
		}
	}
}