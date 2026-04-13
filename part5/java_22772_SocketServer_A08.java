import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_22772_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket socket = null;
        SSLCertificateRequest certificateRequest = null;
        SSLServerSocketFactory sslServerSocketFactory = null;
        SSLContext sslContext = null;

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocketFactory.setEndpointIdentificationAlgorithm("HTTPS");

            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, new TrustManager[] { new TrustAllCertsTrustManager() }, new java.security.SecureRandom());

            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setNeedClientAuth(true);

            socket = (SSLSocket) serverSocket.accept();
            socket.startHandshake();

            SSLCertificate certificate = socket.getCertificate();
            System.out.println("Client Certificate: " + certificate);

            // Here you can implement the operations related to A08_IntegrityFailure
            // ...

            socket.close();
        } finally {
            if (serverSocket != null) serverSocket.close();
        }
    }
}