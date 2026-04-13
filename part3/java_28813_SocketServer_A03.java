import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_28813_SocketServer_A03 {
    private static final int PORT = 8080;
    private static final String SSL_PORT = "8081";

    public static void main(String[] args) throws IOException {
        // Create a server socket with BIO
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server listening on port " + PORT);

        // Create a secure server socket with HTTPS
        SSLServerSocket sslServerSocket = (SSLServerSocket) new SSLServerSocket(Integer.parseInt(SSL_PORT));
        System.out.println("Server listening on port " + SSL_PORT);

        while (true) {
            try {
                // Accept a client connection
                Socket socket = serverSocket.accept();
                SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();

                // Create input and output streams
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                // Echo back any received data
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    out.println(message);
                }

                // Close the socket connections
                socket.close();
                sslSocket.close();
            } catch (SocketException e) {
                // Interruptions, end of stream or other socket-specific exception
                System.out.println("Socket exception: " + e.getMessage());
            }
        }
    }
}