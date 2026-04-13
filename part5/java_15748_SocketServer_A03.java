import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.security.cert.Certificate;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_15748_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(SocketServer.class.getResourceAsStream("/server.jks"), "password".toCharArray());
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8443, (InetAddress) null, keyStore, "password".toCharArray());
        sslServerSocket.setNeedClientAuth(true);

        while (true) {
            SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
            sslSocket.setNeedClientAuth(true);
            InetAddress ip = sslSocket.getRemoteSocketAddress();
            System.out.println("Accepted connection from " + ip);
            OutputStream out = sslSocket.getOutputStream();
            String response = "<html><body><h1>Hello, SSL</h1></body></html>";
            out.write(response.getBytes(StandardCharsets.UTF_8));
            sslSocket.close();
        }
    }
}