package fromBusinesTeam;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author mwilson
 */
public class TcpServer {

	private ServerSocket serverSocket;
	private RequestProcessor requestProcessor;

	public TcpServer(int tcpPort, RequestProcessor requestProcessor)
			throws IOException {
		serverSocket = new ServerSocket(tcpPort);
		this.requestProcessor = requestProcessor;
	}

	public void start() throws IOException {

		int clientNumber = 0;

		while (true) {
			System.out.println("waiting for client...");
			final Socket clientSocket = serverSocket.accept();
			System.out.println("client accepted");

			new Thread(new ClientHandler(clientSocket, requestProcessor),
					"Client-" + (clientNumber++)).start();
			System.out.println("client handler started");
		}

	}

}
