import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_26862_SocketServer_A03 {
    private static SSLServerSocket serverSocket;
    private static SSLSocket socket;

    public static void main(String[] args) {
        // Create server socket
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setNeedClientAuth(true);

            // Accept client
            socket = (SSLSocket) serverSocket.accept();
            socket.startHandshake();

            // Send response
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Hello World");

            // Close connection
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}