import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_38839_SocketServer_A08 {
    private static SSLServerSocket serverSocket;
    private static SSLSocket socket;
    private static BufferedReader in = null;
    private static PrintWriter out = null;

    public static void main(String[] args) throws Exception {
        // Setup the server socket
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(4444);
        serverSocket.setNeedClientAuth(true);

        // Accept client connection
        socket = (SSLSocket) serverSocket.accept();

        // Get input and output stream
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);

        // Handshake
        SSLSession session = socket.getSession();
        if (session == null) {
            throw new IOException("Failed to create session");
        }

        // Print a message
        out.println("Handshake successful");

        // Read a message from client
        String message = in.readLine();
        System.out.println("Client says: " + message);

        // Close connection
        socket.close();
    }
}