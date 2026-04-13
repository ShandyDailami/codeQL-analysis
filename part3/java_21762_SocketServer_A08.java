import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_21762_SocketServer_A08 {

    private static final int port = 12345;

    public static void main(String[] args) throws Exception {
        SSLServerSocket sslServerSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(port);
            sslServerSocket.setNeedClientAuthentication(true);

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new TrustManager[] {new TrustAllCertsTrustManager()}, new java.security.SecureRandom());

            Socket socket = sslServerSocket.accept();
            socket.setSoTimeout(60 * 1000);
            socket.setKeepAlive(true);

            SSLSocket sslSocket = (SSLSocket) sslContext.getSocket(socket);

            BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
            PrintWriter out = new PrintWriter(sslSocket.getOutputStream(), true);

            out.println("Hello World");
            String readLine = in.readLine();
            System.out.println("Server: " + readLine);
        } finally {
            sslServerSocket.close();
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