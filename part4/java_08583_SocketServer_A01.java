import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class java_08583_SocketServer_A01 {

    public static void main(String[] args) {
        try {
            SSLServerSocketFactory sslServerSocketFactory = getSSLServerSocketFactory();
            ServerSocket serverSocket = (ServerSocket) sslServerSocketFactory.createServerSocket(9001);
            System.out.println("Secure server started on port 9001");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");
                SSLServerSocket sslServerSocket = (SSLServerSocket) socket.getChannel().accept();
                System.out.println("Secure connection established");

                // Handle the client connection...
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static SSLServerSocketFactory getSSLServerSocketFactory() {
        SSLServerSocketFactory sslServerSocketFactory = null;

        try {
            sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        } catch (NoSuchAlgorithmException | KeyStoreException | KeyManagementException e) {
            e.printStackTrace();
        }

        return sslServerSocketFactory;
    }
}