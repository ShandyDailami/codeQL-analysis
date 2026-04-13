import java.net.*;
import java.io.*;

public class java_13168_SocketServer_A07 {
    private ServerSocket serverSocket;

    public java_13168_SocketServer_A07(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void startServer() throws IOException {
        System.out.println("Server started on port " + serverSocket.getLocalPort() + "...");
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Accepted connection from " + clientSocket.getRemoteSocketAddress());

            // Perform authentication using BAP
            String authRequest = clientSocket.getInputStream().readUTF();
            String response = authenticateClient(authRequest);

            // Send response back to client
            clientSocket.getOutputStream().writeUTF(response);
            clientSocket.getOutputStream().flush();

            clientSocket.close();
        }
    }

    private String authenticateClient(String request) {
        // Perform authentication logic here. For simplicity, we're just checking if the request is "admin"
        if ("admin".equals(request)) {
            return "Authenticated";
        } else {
            return "Unauthenticated";
        }
    }

    public static void main(String[] args) throws IOException {
        new SecureSocketServer(1234).startServer();
    }
}