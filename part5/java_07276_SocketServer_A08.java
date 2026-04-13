import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_07276_SocketServer_A08 {
    private static final String CLIENT_KEYSTORE = "client.jks";
    private static final String CLIENT_KEYSTORE_PASSWORD = "password";
    private static final String SERVER_KEYSTORE = "server.jks";
    private static final String SERVER_KEYSTORE_PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket clientSocket = null;

        try {
            KeyStore clientkeystore = KeyStore.getInstance("JKS");
            clientkeystore.load(new FileInputStream(CLIENT_KEYSTORE), CLIENT_KEYSTORE_PASSWORD.toCharArray());
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyStore.getDefaultType());
            keyManagerFactory.init(clientkeystore, CLIENT_KEYSTORE_PASSWORD.toCharArray());

            SSLServerSocketFactory sslServerSocketFactory = new SSLServerSocketFactory(keyManagerFactory, new TrustStrategy());
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);

            while (true) {
                clientSocket = serverSocket.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    out.writeBytes("OK\n");
                }
                clientSocket.close();
            }
        } finally {
            serverSocket.close();
        }
    }

    private static class TrustStrategy implements X509TrustManager {
        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) {
        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) {
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }
}