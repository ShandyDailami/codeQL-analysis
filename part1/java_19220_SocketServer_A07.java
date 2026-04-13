import java.io.*;
import java.net.*;
import javax.net.ssl.*;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.MessageDigest;
import java.util.Base64;

public class java_19220_SocketServer_A07 {

    private static final String KEY = "a secret key";

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = new SSLServerSocket(4444, null, null, SSLServerSocket.getDefaultCipherSuites(), null);
        serverSocket.setNeedClientAuth(true);

        SSLSocket socket = (SSLSocket) serverSocket.accept();
        socket.setNeedClientAuth(true);

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, new TrustManager[] { new TrustAnyTrustManager() }, new KeyManager[] { new KeyManager() });

        socket.setSSLContext(sslContext);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        out.writeBytes("HTTP/1.1 200 OK\r\n\r\n");
        out.flush();

        String line;
        while ((line = in.readLine()) != null) {
            System.out.println(line);
        }

        socket.close();
    }

    private static class TrustAnyTrustManager implements X509TrustManager {
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[] {};
        }
        public boolean isServerTrusted(X509Certificate[] certs) {
            return true;
        }
        public boolean isClientTrusted(X509Certificate[] certs) {
            return true;
        }
    }

    private static class KeyManager implements javax.net.ssl.KeyManager {
        public String getPassword() {
            return null;
        }
        public String getAlgorithm() {
            return "SSLv3";
        }
        public Key getKey() {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(KEY.getBytes());
            byte[] bytes = md.digest();
            return new SecretKeySpec(bytes, "AES");
        }
    }
}