import java.net.*;
import java.util.*;
import java.io.*;
import java.security.*;
import javax.net.ssl.*;

public class java_12835_SocketServer_A07 {
    private static final String CLIENT_KEY = "client.key";
    private static final String CLIENT_CERT = "client.cert";

    public static void main(String[] args) throws Exception {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);

        sslServerSocket.setNeedClientAuth(true);

        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(new FileInputStream("mystore.jks"), "mypass".toCharArray());

        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunKSAPI");
        keyManagerFactory.init(keyStore, "mypass".toCharArray());

        SSLServerCertificateExtension defaultSCE = new SSLServerCertificateExtension("");
        sslServerSocket.setServerCertificateUrl("http://localhost/");

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyManagerFactory, new TrustManager[] { defaultSCE }, null);

        SSLServerSocket secureServerSocket = (SSLServerSocket) sslContext.getServerSocket();

        while (true) {
            SSLSocket clientSocket = (SSLSocket) secureServerSocket.accept();
            System.out.println("Client accepted");

            InputStream inputStream = clientSocket.getInputStream();
            OutputStream outputStream = clientSocket.getOutputStream();

            byte[] buffer = new byte[1024];
            int bytesRead = inputStream.read(buffer);
            String message = new String(buffer, 0, bytesRead);
            System.out.println("Received: " + message);

            String response = "Hello Client";
            outputStream.write(response.getBytes());
            outputStream.flush();

            clientSocket.close();
        }
    }
}