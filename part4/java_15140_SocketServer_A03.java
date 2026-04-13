import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.IOException;

public class java_15140_SocketServer_A03 {

    public static void main(String[] args) {
        SSLServerSocket serverSocket = null;

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345);
            serverSocket.setNeedClientAuth(true);

            while (true) {
                SSLSocket sslSocket = (SSLSocket) serverSocket.accept();
                System.out.println("New connection from " + sslSocket.getRemoteSocketAddress());

                // start a new thread to handle the client
                new SecureClientHandler(sslSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}