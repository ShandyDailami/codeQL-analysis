import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_26904_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocket sslServerSocket = (SSLServerSocket) new SSLServerSocket(54321);
            sslServerSocket.setNeedClientAuth(true);
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, new TrustManager[]{new TrustAllCertsTrustManager()}, null);
            serverSocket = (SSLServerSocket) sslContext.getServerSocket(54321);
            serverSocket.setNeedClientAuth(true);
            System.out.println("Waiting for client connection...");
            SSLSocket socket = (SSLSocket) serverSocket.accept();
            System.out.println("Client connected!");
            socket.startHandshake();
            System.out.println("Handshake Complete");
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            serverSocket.close();
        }
    }

    static class TrustAllCertsTrustManager implements X509TrustManager {
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