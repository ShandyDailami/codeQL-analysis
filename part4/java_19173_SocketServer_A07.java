import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_19173_SocketServer_A07 {
    private static final String SSL_PORT = "12345";
    private static SSLServerSocket sslServerSocket = null;

    public static void main(String[] args) {
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(Integer.parseInt(SSL_PORT));
            sslServerSocket.setNeedClientAuth(true);

            while (true) {
                SSLSocket clientSocket = (SSLSocket) sslServerSocket.accept();
                clientSocket.setNeedClientAuth(true);

                SSLInputStream sslIn = new SSLInputStream(clientSocket.getInputStream());
                SSLOutputStream sslOut = new SSLOutputStream(clientSocket.getOutputStream());

                SSLContext sslContext = SSLContext.getInstance("SSL");
                sslContext.init(null, new X509ExtendedKeyManager[] {new CustomX509KeyManager()}, null);

                sslIn = new SSLInputStream(sslIn);
                sslOut = new SSLOutputStream(sslOut);

                sslOut.setNeedClientAuth(true);

                System.out.println("Client Connection Established");

                // Perform your operations here

                sslIn.close();
                sslOut.close();

                clientSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}