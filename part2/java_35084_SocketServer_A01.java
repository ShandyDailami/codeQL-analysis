import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_35084_SocketServer_A01 {

    public static void main(String[] args) throws Exception {
        SSLServerSocket sslServerSocket = null;
        Socket socket = null;
        SSLSocket sslSocket = null;

        try {
            // Create SSL ServerSocket
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            sslServerSocket.setNeedClientAuth(true);

            // Accept client connection
            socket = sslServerSocket.accept();
            sslSocket = (SSLSocket) socket.getSocket();

            // Print Client IP
            InetAddress clientAddress = sslSocket.getRemoteSocketAddress();
            System.out.println("Client IP: " + clientAddress.toString());

            // Send Response
            PrintWriter out = new PrintWriter(sslSocket.getOutputStream(), true);
            out.println("Hello, Client!");
        } finally {
            if (socket != null) socket.close();
            if (sslSocket != null) sslSocket.close();
            if (sslServerSocket != null) sslServerSocket.close();
        }
    }
}