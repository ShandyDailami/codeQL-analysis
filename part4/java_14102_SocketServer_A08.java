import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.CertificateException;

public class java_14102_SocketServer_A08 {

    public static void main(String[] args) throws IOException, CertificateException {
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(SecurityClassLoader.getResourceAsStream("keystore.jks"), "password".toCharArray());

        SSLServerSocket sslServerSocket = new SSLServerSocket(4444, keyStore, null, SSLServerSocket.selectiveAccept(true));

        while (true) {
            SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
            sslSocket.setNeedClientAuth(true);
            OutputStream out = sslSocket.getOutputStream();
            out.write("Hello World\n".getBytes());
            out.flush();
            sslSocket.close();
        }
    }
}