import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocketFactory;

public class java_05397_SocketServer_A07 {

    private static final String SSL_PORT = "443";
    private static final String KEYSTORE_FILE = "keystore.jks";
    private static final String KEYSTORE_PASSWORD = "mypassword";
    private static final String KEY_PASSWORD = "mypassword";

    public static void main(String[] args) {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(Integer.parseInt(SSL_PORT));
            serverSocket.setNeedClientAuth(true);

            while (true) {
                Socket socket = serverSocket.accept();
                SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
                SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket(socket, socket.getInetAddress(), socket.getPort(), true, socket.getSoTimeout());
                sslSocket.setNeedClientAuth(true);

                // Perform auth here
                if (sslSocket.isClientHelloSupported(SSLServerSocketFactory.DEFAULT)
                        && sslSocket.getNeedClientAuth()) {
                    sslSocket.startHandshake();
                    if (sslSocket.getState() == SSLSocket.ESTABLISHED) {
                        System.out.println("Connection accepted from " + sslSocket.getRemoteSocketAddress());
                    } else {
                        System.out.println("Connection declined from " + sslSocket.getRemoteSocketAddress());
                    }
                } else {
                    System.out.println("Client hello not supported or not requested by client.");
                }

                // Perform operations here

                sslSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}