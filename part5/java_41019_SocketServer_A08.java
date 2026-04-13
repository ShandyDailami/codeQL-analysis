import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.cert.CertificateException;

public class java_41019_SocketServer_A08 {

    public static void main(String[] args) {
        try {
            SSLServerSocket sslServerSocket = (SSLServerSocket) new SSLServerSocket(4444);
            sslServerSocket.setNeedClientAuth(true);

            System.out.println("Server started, waiting for client...");

            SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
            sslSocket.startHandshake();

            if (sslSocket.getSession() == null) {
                System.out.println("Failed to start handshake.");
                sslSocket.close();
                sslServerSocket.close();
                return;
            }

            System.out.println("Handshake completed.");

            InputStream inputStream = sslSocket.getInputStream();
            OutputStream outputStream = sslSocket.getOutputStream();

            // Now you can write your code here...

            sslSocket.close();
            sslServerSocket.close();
        } catch (IOException | CertificateException e) {
            e.printStackTrace();
        }
    }
}