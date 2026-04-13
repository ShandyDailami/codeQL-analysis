import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_11445_SocketServer_A07 {
    private static final String CLIENT_IP = "127.0.0.1"; // Specify the client IP
    private static final int PORT = 8888;

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = null;
        SSLServerSocket sslServerSocket = null;

        try {
            // Create a SSL Server Socket
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);
            sslServerSocket.setNeedClientAuthentication(true); // Enable SSL for client authentication

            // Create a Server Socket
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(PORT));

            // Accept client connection
            while (true) {
                Socket clientSocket = sslServerSocket.accept();
                System.out.println("Client connected");

                // Create input and output streams
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                String clientMessage;
                while ((clientMessage = in.readLine()) != null) {
                    System.out.println("Received client: " + clientMessage);
                    out.println("Server: I received your message: " + clientMessage);
                }
            }
        } finally {
            // Close the server socket
            if (sslServerSocket != null) sslServerSocket.close();
            if (serverSocket != null) serverSocket.close();
        }
    }
}