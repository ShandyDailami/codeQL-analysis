import java.net.*;
import java.io.*;
import java.util.*;
import javax.net.ssl.*;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class java_07297_SocketServer_A07 {

    private static final String ALGORITHM = "AES";
    private static final String KEY = "12345678abcdefgh";

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket sslSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            sslSocket = (SSLSocket) serverSocket.accept();

            BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
            PrintWriter out = new PrintWriter(sslSocket.getOutputStream(), true);

            out.println("Server: Hello, Client!");
            String message = in.readLine();
            System.out.println("Client says: " + message);

            SSLSession sslSession = sslSocket.getSession();
            sslSession.setCipherSuites(new String[]{"TLS_DHE_RSA_WITH_AES_128_CBC_SHA256"});
            sslSession.setKeyAndCertificate(KeyStore.getDefaultType(), "server_keystore", "server_keystore_password", new ArrayList<Protocol>());

            byte[] decode = Base64.getDecoder().decode("UEsDBBAggoIA...");
            SecretKey key = new SecretKeySpec(decode, 0, decode.length, "AES");
            Cipher cipher = Cipher.getInstance(key.getAlgorithm());
            cipher.init(Cipher.DECRYPT_MODE, key);
            String decryptedMessage = new String(cipher.doFinal(Base64.getDecoder().decode(message)), "UTF-8");

            System.out.println("Decrypted message: " + decryptedMessage);

            sslSocket.close();
        } finally {
            if (serverSocket != null) serverSocket.close();
            if (sslSocket != null) sslSocket.close();
        }
    }
}