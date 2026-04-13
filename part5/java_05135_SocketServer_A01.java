import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_05135_SocketServer_A01 {
    private static final String SSL_PORT = "9999";
    private static final String PLAIN_PORT = "9998";

    public static void main(String[] args) {
        boolean usePlainSocket = false;
        if (usePlainSocket) {
            startPlainSocketServer();
        } else {
            startSecureSocketServer();
        }
    }

    private static void startSecureSocketServer() {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        try {
            SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(Integer.parseInt(SSL_PORT));
            sslServerSocket.setNeedClientAuth(true);
            while (true) {
                SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
                new SecureSocketServerThread(sslSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void startPlainSocketServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(Integer.parseInt(PLAIN_PORT));
            while (true) {
                Socket socket = serverSocket.accept();
                new SocketServerThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}