import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_24044_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            SSLServerSocket sslServerSocket = (SSLServerSocket) new SSLServerSocket(8080);
            sslServerSocket.setNeedClientAuth(true);

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new TrustManager[] {new TrustAllCertsTrustManager()}, new java.security.SecureRandom());
            sslServerSocket.setSSLContext(sslContext);

            System.out.println("Waiting for client connections...");

            Socket socket = sslServerSocket.accept();
            System.out.println("Client accepted!");

            SSLSocket sslSocket = (SSLSocket) socket.getSocket();

            InputStream inputStream = sslSocket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println("Received: " + message);
            }

            sslSocket.close();
            sslServerSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class TrustAllCertsTrustManager implements X509TrustManager {
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public boolean isTrusted(X509Certificate[] certs) {
            return true;
        }

        public boolean checkClientTrusted(X509Certificate[] certs, String authType) {
            return true;
        }

        public boolean checkServerTrusted(X509Certificate[] certs, String authType) {
            return true;
        }
    }
}