import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_41178_SocketServer_A01 {
    private static final String SSL_PORT = "12345";

    public static void main(String[] args) throws IOException {
        SSLServerSocket sslServerSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocket.factory();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(Integer.parseInt(SSL_PORT));
            sslServerSocket.setNeedClientAuthentication(true);

            SSLSocket clientSocket = (SSLSocket) sslServerSocket.accept();
            clientSocket.startHandshake();

            System.out.println("Handshake completed.");

            // Here you can now read and write using SSLSocket

            clientSocket.close();
        } catch (SSLException e) {
            e.printStackTrace();
        } finally {
            sslServerSocket.close();
        }
    }
}