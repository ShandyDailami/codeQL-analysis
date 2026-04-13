import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.security.KeyStore;
import java.security.cert.Certificate;

public class java_26660_SocketServer_A08 {
    private final int port;
    private SSLServerSocket sslServerSocket;

    public java_26660_SocketServer_A08(int port) {
        this.port = port;
    }

    public void start() {
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocket.getDefaultSSLServerSocketFactory();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(port, 0, null);

            sslServerSocket.setNeedClientAuth(true);
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(getClass().getResourceAsStream("/client.jks"), "password".toCharArray());

            sslServerSocket.setKeyStore(keyStore);

            sslServerSocket.setCertificateAuthorities(getCertificateAuthorities());
            sslServerSocket.setCipherSuites(KeyStore.DEFAULT_CIPHER_SUITES);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Server started, waiting for client connections on port " + port + "...");

        while (true) {
            try {
                SSLSocket clientSocket = (SSLSocket) sslServerSocket.accept();
                clientSocket.setNeedClientAuth(true);

                InputStream inputStream = clientSocket.getInputStream();
                OutputStream outputStream = clientSocket.getOutputStream();

                byte[] buffer = new byte[1024];
                int bytesRead = inputStream.read(buffer);
                String message = new String(buffer, 0, bytesRead);

                System.out.println("Received: " + message);

                String response = "Hello, Client!";
                outputStream.write(response.getBytes());
                outputStream.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private Certificate[] getCertificateAuthorities() {
        try {
            Certificate certificate = KeyStore.getInstance("JKS").getCertificate("client").getCertificate();
            return new Certificate[]{certificate};
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}