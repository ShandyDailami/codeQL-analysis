import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_34044_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        SSLServer(1234);
    }

    public static void SSLServer(int port) throws Exception {
        ServerSocket sock = new ServerSocket(port);
        SSLServerSocket secureSock = (SSLServerSocket) sock;
        secureSock.setNeedClientAuth(true);

        SSLContext sslContext = SSLContext.getInstance("TLSv1_2");
        sslContext.init(null, new TrustManager[] { new TrustAllCerts() }, null);

        while (true) {
            SSLSocket connectionSocket = (SSLSocket) secureSock.accept();
            connectionSocket.setNeedClientAuth(true);
            SSLSession session = connectionSocket.getSession();

            System.out.println("Client connected: " + connectionSocket.getRemoteSocketAddress());

            OutputStream out = connectionSocket.getOutputStream();
            PrintWriter writer = new PrintWriter(out, true);
            writer.println("Hello, client!");

            connectionSocket.close();
        }
    }

    public static class TrustAllCerts implements X509TrustManager {
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public void checkClientTrusted(X509Certificate[] certs, String authType) {
            // Not used, but required by X509TrustManager
        }

        public void checkServerTrusted(X509Certificate[] certs, String authType) {
            // Not used, but required by X509TrustManager
        }
    }
}