import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.CertificateException;

public class java_01152_SocketServer_A08 {
    public static void main(String[] args) throws IOException, CertificateException {
        // Initialize a SSLServerSocketFactory with a truststore
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        sslServerSocketFactory.setKeyStore(KeyStore.getInstance("JKS"), "password".toCharArray());
        sslServerSocketFactory.setKeyStorePassword("password");

        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
        sslServerSocket.setNeedClientAuth(true);

        System.out.println("Waiting for client connection...");
        Socket socket = sslServerSocket.accept();
        System.out.println("Client connected!");

        // Set up input and output streams
        InputStream input = socket.getInputStream();
        OutputStream output = socket.getOutputStream();

        // Send a message to the client
        output.write("Hello, client!".getBytes());
        output.close();

        // Receive a message from the client
        byte[] buffer = new byte[256];
        int bytesRead = input.read(buffer);
        System.out.println("Received: " + new String(buffer, 0, bytesRead));

        // Close the socket
        socket.close();
    }
}