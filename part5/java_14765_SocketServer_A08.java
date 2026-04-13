import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

public class java_14765_SocketServer_A08 {

    private static SSLServerSocket serverSocket;
    private static Socket socket;

    private static TrustManager[] trustAllCerts;

    public static void main(String[] args) {

        try {
            trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        public X509Certificate[] getAcceptedIssuers() {
                            return null;
                        }
                        public void checkClientTrusted(X509Certificate[] certs, String authType) {
                        }
                        public void checkServerTrusted(X509Certificate[] certs, String authType) {
                        }
                    }
            };
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        String host = InetAddress.getLocalHost().getHostAddress();
        int port = 8080;

        System.out.println("Server started at " + host + ":" + port);

        try {
            serverSocket = (SSLServerSocket) new SSLServerSocket(port);
            serverSocket.setNeedClientAuth(true);
            serverSocket.setTrustManager(new TrustManager[]{new X509TrustManager()});
            socket = serverSocket.accept();

            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public class X509TrustManager implements TrustManager {
        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
            return null;
        }
        public void checkClientTrusted(
                java.security.cert.X509Certificate[] certs, String authType) {
        }
        public void checkServerTrusted(
                java.security.cert.X509Certificate[] certs, String authType) {
        }
    }
}