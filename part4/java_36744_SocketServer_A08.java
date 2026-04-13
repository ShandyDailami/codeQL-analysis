import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.Certificate;

public class java_36744_SocketServer_A08 {

    public static void main(String[] args) throws Exception {
        String path = "/path/to/your/keystore";
        String password = "your_password";

        SSLServerSocketFactory sslServerSocketFactory =
                (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(4444);
        sslServerSocket.setNeedClientAuth(true);

        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(new java.security.cert.CertificateRequestor() {
            public Certificate[] getCertificateChain(String[] s) {
                return null;
            }
            public java.security.PrivateKey getPrivateKey() {
                return null;
            }
        }, new java.security.PrivateKey[]{});

        sslServerSocket.setKeyStore(keyStore);

        SSLSocket client = (SSLSocket) sslServerSocket.accept();
        client.startHandshake();

        System.out.println("Client certificate: " + client.getRemoteSocketCertificate());

        BufferedReader in = new BufferedReader(
                new InputStreamReader(client.getInputStream()));
        OutputStream out = client.getOutputStream();
        String userInput;
        while ((userInput = in.readLine()) != null) {
            System.out.println("Received: " + userInput);
            out.write((userInput + "\n").getBytes());
        }

        client.close();
    }
}