import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_20740_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        SSLServerSocket serverSocket = null;
        SSLSocket clientSocket = null;

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(4444, null);
            serverSocket.setNeedClientAuth(true);

            while (true) {
                clientSocket = serverSocket.accept();
                clientSocket.startHandshake();
                SSLCertificate cert = clientSocket.getSession()
                        .getPeerCertificate();
                System.out.println("Handshake completed. Certificate: " + cert);
                clientSocket.close();
            }
        } catch (IOException ex) {
            System.out.println("IOException in server: " + ex.getMessage());
        } finally {
            if (serverSocket != null) serverSocket.close();
        }
    }
}