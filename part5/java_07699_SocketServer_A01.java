import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_07699_SocketServer_A01 {
    private static final String CLIENT_KEY = "client.key";
    private static final String CLIENT_CERT = "client.crt";

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        try {
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(new FileInputStream("mykeystore.jks"), "password".toCharArray());

            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyFactory.getDefaultAlgorithm());
            keyManagerFactory.init(keyStore, "password".toCharArray());

            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);

            SSLServerSocketFactory sslServerSocketFactory = new SSLServerSocketFactory(keyManagerFactory, trustManagerFactory);
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);

            while (true) {
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                System.out.println("Client accepted");
                new Handler(clientSocket).start();
            }
        } finally {
            serverSocket.close();
        }
    }

    private static class Handler extends Thread {
        private final SSLSocket socket;

        public java_07699_SocketServer_A01(SSLSocket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                SSLContext context = SSLContext.getInstance("TLS");
                context.init(null, new TrustManager[]{new TrustAllCerts()}, new java.security.SecureRandom());
                socket.setNeedClientAuth(true);
                socket.setSSLSocketFactory(context.getSSLSocketFactory());
                InputStreamReader isr = new InputStreamReader(socket.getInputStream());
                BufferedReader br = new BufferedReader(isr);
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static class TrustAllCerts implements X509TrustManager {
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
        public void checkClientTrusted(X509Certificate[] certs, String authType) {
            return;
        }
        public void checkServerTrusted(X509Certificate[] certs, String authType) {
            return;
        }
    }
}