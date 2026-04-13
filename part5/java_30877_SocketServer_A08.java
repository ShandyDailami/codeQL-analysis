import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_30877_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket socket = null;

        try {
            // Create a SSLServerSocket and bind it to port 12345.
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345);
            serverSocket.setEnabledRoots(true);

            // Accept a client connection
            socket = (SSLSocket) serverSocket.accept();

            // Enable SSL on the socket
            socket.startHandshake();
            SSLSocket sslSocket = (SSLSocket) socket.getSocket();

            // Use SSLSocket for communication
            DataInputStream in = new DataInputStream(sslSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(sslSocket.getOutputStream());

            // Send a message to the client
            out.writeUTF("Hello, Client!");

            // Receive a message from the client
            String message = in.readUTF();
            System.out.println("Server received: " + message);

            // Close the socket
            socket.close();
            serverSocket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}