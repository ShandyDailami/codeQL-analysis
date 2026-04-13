import javax.net.ssl.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_17311_SocketServer_A08 {

    public static void main(String[] args) throws Exception {
        SSLServerSocket sslServerSocket = null;
        try {
            SSLServerSocket sslServerSocket = (SSLServerSocket) new SSLServerSocket(8080);
            sslServerSocket.setNeedClientAuth(true);
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new TrustManager[] { new X509TrustManager() }, null);
            sslServerSocket.setSSLContext(sslContext);
            while (true) {
                Socket socket = sslServerSocket.accept();
                new ConnectionHandler(socket).start();
            }
        } catch (SSLException e) {
            System.out.println("Error creating SSLServerSocket: " + e.getMessage());
        } finally {
            sslServerSocket.close();
        }
    }
}