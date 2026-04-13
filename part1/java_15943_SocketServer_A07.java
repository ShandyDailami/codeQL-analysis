import java.io.*;
import java.net.*;

public class java_15943_SocketServer_A07 {
    private ServerSocket serverSocket;

    public java_15943_SocketServer_A07(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void startServer() throws IOException {
        while (true) {
            System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Accepted new client from " + clientSocket.getRemoteSocketAddress());

            // Send authentication request
            DataOutputStream outToClient = new DataOutputStream(clientSocket.getOutputStream());
            outToClient.writeUTF("Authentication Request");

            // Receive authentication response
            DataInputStream inFromClient = new DataInputStream(clientSocket.getInputStream());
            String response = inFromClient.readUTF();
            if ("Authentication Success".equals(response)) {
                // Authentication successful, continue communication
                outToClient.writeUTF("Authentication Success");
            } else {
                // Authentication failed, close connection
                outToClient.writeUTF("Authentication Failure");
                clientSocket.close();
           
            }

            // Close the current connection
            clientSocket.close();
        }
    }

    public static void main(String[] args) throws IOException {
        int port = 4445;
        SocketServer server = new SocketServer(port);
        server.startServer();
    }
}