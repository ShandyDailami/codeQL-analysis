import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class java_17853_SocketServer_A08 {

    public static void main(String[] args) throws IOException {

        // Step 1: Set up the server socket
        ServerSocket serverSocket = null;
        SSLServerSocket sslServerSocket = null;

        // Use SSL
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        try {
            // Bind the server socket to port 12345 with certificate
            serverSocket = new ServerSocket(12345);
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345, (InetAddress) null);

            // Set up SSL Context
            sslServerSocket.setNeedClientAuth(true);
            sslServerSocket.setEnabledCipherSuites(sslServerSocket.getSupportedCipherSuites());

            System.out.println("Waiting for client on port 12345");

            // Step 2: Accept client connection
            Socket socket = sslServerSocket.accept();
            System.out.println("Client connected");

            // TODO: Handle the client connection

        } catch (Exception e) {
            e.printStackTrace();
       
        } finally {
            // Close the server socket
            if (serverSocket != null)
                serverSocket.close();
            if (sslServerSocket != null)
                sslServerSocket.close();
        }
    }
}