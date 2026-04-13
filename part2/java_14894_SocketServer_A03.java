import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_14894_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket sslServerSocket = null;
        Socket socket = null;

        // Create SSL Server socket
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345);
        sslServerSocket.setNeedClientAuth(true);

        // Accept client connection
        socket = sslServerSocket.accept();

        System.out.println("Client connected");

        // Create new SSL socket
        SSLSocket sslSocket = (SSLSocket) socket.createChannel(socket.getInetAddress());

        // Setup SSL connection
        sslSocket.startHandshake();

        // Read from the SSL socket
        InputStream inputStream = sslSocket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println("Received: " + line);
        }

        sslSocket.close();
    }
}