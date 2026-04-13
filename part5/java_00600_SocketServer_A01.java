import javax.net.ssl.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_00600_SocketServer_A01 {
    private static SSLServerSocket serverSocket;
    private static SSLSocket socket;
    private static SSLContext sslContext;
    private static InputStream inputStream;

    public static void main(String[] args) throws IOException {
        init();
        acceptClient();
    }

    private static void init() throws IOException {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocket.factory();
        serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
        sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, new TrustManager[]{new TrustAllCerts()}, null);
        serverSocket.setNeedClientAuth(true);
    }

    private static void acceptClient() throws IOException {
        socket = (SSLSocket) serverSocket.accept();
        socket.setNeedClientAuth(true);
        inputStream = socket.getInputStream();
        SSLSession sslSession = socket.getSession();
        System.out.println(sslSession);
    }

    private static class TrustAllCerts implements X509TrustManager {
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }

        public void checkClientTrusted(X509Certificate[] certs, String authType) {
        }

        public void checkServerTrusted(X509Certificate[] certs, String authType) {
        }
    }
}