import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_18119_SocketServer_A03 {

    private static final String SSL_PROTOCOL = "SSL";
    private static final int PORT = 8080;

    public static void main(String[] args) throws Exception {
        SSLServerSocket sslServerSocket = null;
        try {
            // Create a server socket with SSL
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);
            sslServerSocket.setNeedClientAuth(true);
            sslServerSocket.setEnabledProtocols(new String[] { SSL_PROTOCOL });

            // Accept a client connection
            SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
            sslSocket.startHandshake();

            // Create a reader and writer
            BufferedReader reader = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
            DataOutputStream writer = new DataOutputStream(sslSocket.getOutputStream());

            // Read and write a message
            String message = reader.readLine();
            writer.write((message + "\r\n").getBytes());
            writer.flush();
            System.out.println("Server received: " + message);

            sslSocket.close();
        } finally {
            sslServerSocket.close();
        }
    }
}