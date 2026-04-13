import javax.net.ssl.*;
import java.net.*;
import java.io.*;

public class java_35416_SocketServer_A08 {
    private static final String CLIENT_MSG = "Hello from server!";
    private static SSLServerSocket serverSocket;
    private static SSLSocket clientSocket;
    private static PrintWriter out;
    private static BufferedReader in;

    public static void main(String[] args) throws Exception {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
        serverSocket.setEnabledCipherSuites(new String[]{"TLSv1"});
        SSLContext sslContext = SSLContext.getInstance("TLSv1");
        sslContext.init(null, new TrustManager[] {new TrustAllCerts()}, new java.security.SecureRandom());
        serverSocket.setSSLContext(sslContext);
        while (true) {
            clientSocket = (SSLServerSocket).accept(serverSocket);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out.println(CLIENT_MSG);
            String message = in.readLine();
            System.out.println("Server received: " + message);
            clientSocket.close();
        }
    }

    static class TrustAllCerts extends X509TrustManager {
        public javax.security.auth.x500.X500Principal[] getAcceptedIssuers() {
            return new javax.security.auth.x500.X500Principal[0];
        }
        public void checkClientTrusted(X509Certificate[] chain, String authType) {
        }
        public void checkServerTrusted(X509Certificate[] chain, String authType) {
        }
    }
}