import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_16728_SocketServer_A08 {
    private static final String CLIENT_AUTH_DIALOG =
        "Performing SSL handshake";
    private static final String CLIENT_AUTH_FAILURE =
        "Client authentication failed";
    private static final int PORT = 8080;

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory =
                (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);
            serverSocket.setNeedClientAuth(true);
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, new TrustManager[] { new TrustAnyTrustManager() }, null);
            serverSocket.setSSLContext(sslContext);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                SSLSocket sslSocket = (SSLSocket) clientSocket.getSocket();
                System.out.println("Client connected");
                OutputStream out = sslSocket.getOutputStream();
                PrintWriter writer = new PrintWriter(out, true);
                writer.println("Hello Client");
                sslSocket.close();
            }
        } finally {
            serverSocket.close();
        }
    }

    static class TrustAnyTrustManager implements X509TrustManager {
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public boolean isTrusted(X509Certificate[] chain) {
            return true;
        }

        public void validateCertificate(X509Certificate cert)
            throws CertificateException {
            return;
        }
    }
}