import java.net.*;
import java.io.*;
import java.security.Key;
import java.security.KeyStore;
import javax.net.ssl.*;
import javax.security.auth.cert.CertificateException;

public class java_23816_SocketServer_A01 {

    private static final String KEYSTORE_PATH = "path_to_your_keystore";
    private static final String KEYSTORE_PASSWORD = "your_keystore_password";
    private static final String KEY_ALIAS = "your_key_alias";
    private static final String KEY_PASSWORD = "your_key_password";

    public static void main(String[] args) throws Exception {
        ServerSocket socket = null;
        SSLServerSocket sslSocket = null;
        KeyStore keyStore = KeyStore.getInstance("JKS");
        char[] password = KEY_PASSWORD.toCharArray();

        try {
            keyStore.load(new FileInputStream(KEYSTORE_PATH), password);
            SSLServerSocketFactory sslSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            socket = (ServerSocket) sslSocketFactory.createServerSocket(8080);
            sslSocket = (SSLServerSocket) sslSocketFactory.createServerSocket(8080, (Socket) null, keyStore, password);
            sslSocket.setNeedClientAuth(true);
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            Socket connection = sslSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            String request = in.readLine();
            System.out.println("Received: " + request);
            out.writeBytes("HTTP/1.1 200 OK\r\n\r\n");
            out.flush();
            connection.close();
        }
    }
}