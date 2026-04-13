import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_13608_SocketServer_A07 {

    private final int port;
    private final String directory;
    private final String keystorePath;
    private final char[] password;

    public java_13608_SocketServer_A07(int port, String directory, String keystorePath, char[] password) {
        this.port = port;
        this.directory = directory;
        this.keystorePath = keystorePath;
        this.password = password;
    }

    public void start() {
        try {
            SSLServerSocket sslServerSocket = (SSLServerSocket) new SSLServerSocket(port);
            System.out.println("Server is running on port " + port);

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new TrustManager[] { new TrustAnyCertsTrustManager() }, new KeyManager[] { new KeyManagerWithPassword() }, null);

            while (true) {
                Socket socket = sslServerSocket.accept();
                SSLSocket sslSocket = (SSLSocket) socket.getChannel().newChannel();
                sslSocket.setSSLContext(sslContext);
                sslSocket.startHandshake();

                String filePath = sslSocket.getRemoteSocketAddress().toString().replace(":", "").replace("/", "").split("=")[1].trim() + "/";
                filePath = directory + filePath;
                System.out.println("Received connection from " + sslSocket.getRemoteSocketAddress());

                try (InputStream inputStream = new FileInputStream(filePath)) {
                    OutputStream outputStream = sslSocket.getOutputStream();
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                    outputStream.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                sslSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SecureSocketServer(8443, "/path/to/directory/", "/path/to/keystore", 'p'.toCharArray()).start();
    }

    static class TrustAnyCertsTrustManager implements X509TrustManager {
        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    static class KeyManagerWithPassword extends KeyManager {
        private KeyStore keyStore;

        public java_13608_SocketServer_A07() throws NoSuchAlgorithmException, KeyStoreException {
            this.keyStore = KeyStore.getInstance("JKS");
            this.keyStore.load(new FileInputStream("path/to/keystore.jks"), password);
            this.km = new KeyManager[] { new KeyManagerWithPassword() };
        }

        @Override
        public Key getKeyForCertificate(String cert) throws UnrecoverableKeyException, KeyManagementException {
            return this.keyStore.getKey(cert, password);
        }
    }
}