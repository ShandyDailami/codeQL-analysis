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

public class java_01854_SocketServer_A08 {
    public static void main(String[] args) throws IOException, CertificateException {
        KeyStore keyStore = KeyStore.getInstance("JKS");
        InputStream inputStream = SocketServer.class.getResourceAsStream("/client.jks");
        keyStore.load(inputStream, "password".toCharArray());

        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);

        SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
        sslSocket.setNeedClientAuthentication(true);

        sslSocket.setEnabledCertificates(keyStore);

        OutputStream outputStream = sslSocket.getOutputStream();
        InputStream inputStream = sslSocket.getInputStream();

        // Write your message here
        String message = "Hello, Client!";
        outputStream.write(message.getBytes());

        byte[] buffer = new byte[1024];
        int bytesRead = inputStream.read(buffer);
        String response = new String(buffer, 0, bytesRead);
        System.out.println("Server received: " + response);

        sslSocket.close();
    }
}