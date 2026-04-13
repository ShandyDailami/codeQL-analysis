import javax.net.ssl.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_13049_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        SSLServerSocket serverSocket = null;
        Socket socket = null;

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);

            while (true) {
                socket = serverSocket.accept();

                SSLSocket sslSocket = (SSLSocket) socket.createChannel(socket.getInetAddress(), socket.getPort());
                sslSocket.setNeedClientAuth(true);

                SSLContext sslContext = SSLContext.getInstance("SSL");
                sslContext.init(null, new X509KeyManager[]{new X509KeyManager()}, new java.security.SecureRandom());

                sslSocket.setSSLContext(sslContext);

                sslSocket.startHandshake();
                sslSocket.close();
            }
        } finally {
            if (serverSocket != null) serverSocket.close();
            if (socket != null) socket.close();
        }
    }
}