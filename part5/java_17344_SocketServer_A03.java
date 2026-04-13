import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_17344_SocketServer_A03 {
    private ServerSocket serverSocket;

    public java_17344_SocketServer_A03(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void startServer() throws IOException {
        System.out.println("Server started on port " + serverSocket.getLocalPort() + "...");

        while (!serverSocket.isClosed()) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Accepted a new client from " + clientSocket.getRemoteSocketAddress());

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String clientMessage;
            while (true) {
                clientMessage = in.readLine();
                if (clientMessage == null) break;
                System.out.println("Received from client: " + clientMessage);

                // For demonstration purposes, we'll just echo back the message
                out.println("Server echo: " + clientMessage);
            }

            clientSocket.close();
        }
    }

    public static void main(String[] args) throws IOException {
        SocketServer server = new SocketServer(5000);
        server.startServer();
    }
}