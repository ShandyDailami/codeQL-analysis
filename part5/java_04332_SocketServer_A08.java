import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_04332_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket clientSocket = null;
        BufferedReader inFromClient = null;

        try {
            // Create a SSLServerSocket and bind it to the port
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setNeedClientAuth(true);

            // Accept a client connection
            clientSocket = (SSLSocket) serverSocket.accept();

            // Create input and output streams
            inFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(clientSocket.getOutputStream());

            // Send a greeting message to the client
            outToClient.writeUTF("Hello, Client!");
            outToClient.flush();

            // Read the greeting from the client
            String message = inFromClient.readLine();
            System.out.println("Server received: " + message);

            // Close the streams
            inFromClient.close();
            outToClient.close();
            clientSocket.close();
        } finally {
            // Close the server socket
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}