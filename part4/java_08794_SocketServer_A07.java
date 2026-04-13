import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_08794_SocketServer_A07 {
    private static final String CLIENT_KEY_STORE = "client.jks";
    private static final String CLIENT_KEY_PASSWORD = "password";
    private static final String CLIENT_TRUST_STORE = "client.jks";
    private static final String CLIENT_TRUST_STORE_PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        SSLServerSocket sslServerSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(5000);
            sslServerSocket.setNeedClientAuth(true);

            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(new FileInputStream(CLIENT_KEY_STORE), CLIENT_KEY_PASSWORD.toCharArray());

            KeyStore trustStore = KeyStore.getInstance("JKS");
            trustStore.load(new FileInputStream(CLIENT_TRUST_STORE), CLIENT_TRUST_STORE_PASSWORD.toCharArray());

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyStore, trustStore, null);

            sslServerSocket.setNeedClientAuth(true);

            Socket client = sslServerSocket.accept();
            SSLSocket sslSocket = (SSLSocket) sslContext.getSocket(client);

            BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
            DataOutputStream out = new DataOutputStream(sslSocket.getOutputStream());

            out.write("Hello Client! ".getBytes());
            out.flush();

            String line;
            while ((line = in.readLine()) != null) {
                System.out.println("Server received: " + line);
            }
        } finally {
            sslServerSocket.close();
        }
    }
}