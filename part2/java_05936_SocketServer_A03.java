import java.net.*;
import java.io.*;
import javax.net.ssl.*;

public class java_05936_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket sslServerSocket = null;
        SSLSocket sslSocket = null;

        try {
            // Create an SSLServerSocket
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            sslServerSocket.setNeedClientAuth(true);

            // Accept an incoming connection
            sslSocket = (SSLSocket) sslServerSocket.accept();

            // Perform SSL handshake
            sslSocket.startHandshake();

            // Check if client authenticated
            if (sslSocket.getSession() != null) {
                System.out.println("Client authenticated successfully!");
            } else {
                System.out.println("Client failed to authenticate!");
            }
        } catch (SSLException e) {
            e.printStackTrace();
        } finally {
            // Close the SSLSocket
            if (sslSocket != null) {
                sslSocket.close();
            }

            // Close the SSLServerSocket
            if (sslServerSocket != null) {
                sslServerSocket.close();
            }
        }
    }
}