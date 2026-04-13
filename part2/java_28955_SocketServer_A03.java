import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_28955_SocketServer_A03 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        SSLServerSocket sslServerSocket = null;
        try {
            // Create a SSLServerSocket
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);
            sslServerSocket.setNeedClientAuth(true);

            // Accept client connections
            SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();

            // Perform the SSL handshake
            sslSocket.handshake();

            // Create a BufferedReader for the SSLSocket input stream
            InputStreamReader isr = new InputStreamReader(sslSocket.getInputStream());
            BufferedReader br = new BufferedReader(isr);

            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                System.out.println("Server received: " + inputLine);
            }

            sslSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}