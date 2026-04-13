import java.net.*;
import java.io.*;

public class java_06497_SocketServer_A03 {

    private ServerSocket serverSocket;

    public java_06497_SocketServer_A03(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void startServer() throws IOException {
        System.out.println("Server started on port: " + serverSocket.getLocalPort() + "...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("A client has connected: " + clientSocket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received: " + message);

            String response = "Hello client, you connected to port " + serverSocket.getLocalPort();
            out.writeUTF(response);
            System.out.println("Sent: " + response);

            clientSocket.close();
        }
    }

    public static void main(String[] args) throws IOException {
        new SocketServer(1234).startServer();
    }
}