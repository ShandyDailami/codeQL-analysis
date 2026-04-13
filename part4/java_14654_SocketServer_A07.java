import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_14654_SocketServer_A07 {

    private static SSLServerSocket serverSocket;
    private static SSLContext sslContext;

    public static void main(String[] args) throws Exception {

        // Create a SSLServerSocket
        SSLServerSocketFactory sslServerSocketFactory = sslContext.getServerSocketFactory();
        serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345);
        serverSocket.setNeedClientAuth(true);

        while (true) {

            // Wait for client connection
            SSLSocket sslSocket = (SSLSocket) serverSocket.accept();

            // Enable client hello read
            sslSocket.startHandshake();

            // Display certificate
            System.out.println("Client Hello: " + sslSocket.getRemoteSocketAddress());

            // Continue communication with the client
            InputStream is = sslSocket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("Received: " + line);
            }

            sslSocket.close();
        }
    }
}