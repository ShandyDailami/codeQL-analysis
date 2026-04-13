import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_27040_SocketServer_A08 {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = null;
        SSLServerSocket sslServerSocket = null;
        Socket socket = null;

        try {
            // Step 1: Create SSL Server Socket
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345);
            sslServerSocket.setNeedClientAuth(true);

            // Step 2: Accept client connection
            serverSocket = sslServerSocket.accept();
            SSLSocket sslSocket = (SSLSocket) serverSocket.getInputStream();

            // Step 3: Verify client SSL certificate
            X509Certificate clientCert = sslSocket.getRemoteCertificate();
            System.out.println("Client certificate is: " + clientCert);

            // Step 4: Create socket
            socket = sslServerSocket.accept();

            // Now you can read/write using socket
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close the sockets
            if (socket != null) socket.close();
            if (serverSocket != null) serverSocket.close();
       
        }
    }
}