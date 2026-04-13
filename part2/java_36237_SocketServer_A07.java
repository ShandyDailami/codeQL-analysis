import java.net.Socket;
import java.net.ServerSocket;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLContext;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManagerFactory;

public class java_36237_SocketServer_A07 {
    private static final String KEY_STORE = "mykeystore";
    private static final char[] KEY_STORE_PASSWORD = "mystorepassword".toCharArray();
    private static final String TRUST_STORE = "mytruststore";
    private static final char[] TRUST_STORE_PASSWORD = "mytruststorepassword".toCharArray();
    private static final String KEY_ALIAS = "mypassword";

    public static void main(String[] args) throws Exception {
        SSLContext sslContext = createSSLContext();
        ServerSocket serverSocket = (ServerSocket) sslContext.getServerSocket(8080);
        while (true) {
            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            InputStream input = clientSocket.getInputStream();
            OutputStream output = clientSocket.getOutputStream();
            handleClient(input, output);
            clientSocket.close();
        }
    }

    private static void handleClient(InputStream input, OutputStream output) throws IOException {
        // TODO: Add your authentication code here
        // For simplicity, we assume the user's password is correct
        byte[] buffer = new byte[1024];
        int length = input.read(buffer);
        String password = new String(buffer, 0, length);
        if ("correctpassword".equals(password)) {
            output.write("OK\n".getBytes());
        } else {
            output.write("FAIL\n".getBytes());
        }
    }

    private static SSLContext createSSLContext() throws Exception {
        KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunKSAPI");
        TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunJSSE");
        kmf.init(new KeyStorePasswordCallback(KEY_STORE, KEY_STORE_PASSWORD), new KeyStorePasswordCallback(null, null));
        tmf.init(new KeyStorePasswordCallback(TRUST_STORE, TRUST_STORE_PASSWORD), new KeyStorePasswordCallback(null, null));
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);
        return sslContext;
    }

    private static class KeyStorePasswordCallback implements javax.net.ssl.PasswordCallback {
        private String keystore;
        private char[] password;

        public java_36237_SocketServer_A07(String keystore, char[] password) {
            this.keystore = keystore;
            this.password = password;
        }

        public char[] getPassword() {
            return password;
        }

        public String getPassword(String target) {
            return new String(password);
        }

        public void handle(String s) throws CertificateException, IOException {
            // Not used
        }

        public void init(javax.net.ssl.KeyStore keystore, javax.net.ssl.TrustStore truststore) {
            // Not used
        }

        public boolean equals(Object o) {
            // Not used
            return false;
        }

        public int hashCode() {
            // Not used
            return 0;
        }

        public String toString() {
            // Not used
            return "KeyStorePasswordCallback";
        }

        public KeyStore getKeyStore() {
            // Not used
            return null;
        }

        public char[] getKeyStorePassword() {
            return password;
        }

        public char[] getPassword(String s) {
            return password;
        }
    }
}