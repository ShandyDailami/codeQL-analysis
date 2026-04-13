import javax.net.ssl.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_07336_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        SSLServerSocket sslServerSocket = null;
        Socket socket = null;

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            sslServerSocket.setNeedClientAuth(true);

            System.out.println("Server waiting for client connection...");

            // Accept client connection
            socket = sslServerSocket.accept();
            System.out.println("Client connected");

            // Get input stream
            InputStream inputStream = socket.getInputStream();
            SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();

            // Setup SSL connection
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new TrustManager[] { new TrustAllCerts() }, null);
            sslSocket.setSSLContext(sslContext);

            // Print received data from client
            int len;
            char[] buf = new char[1024];
            while ((len = inputStream.read(buf)) != -1) {
                System.out.print(new String(buf, 0, len));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sslServerSocket != null) {
                sslServerSocket.close();
            }
            if (socket != null) {
                socket.close();
            }
        }
    }
}