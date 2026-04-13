import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_38938_SocketServer_A07 {

    public static void main(String[] args) throws Exception {
        SSLServerSocket sslServerSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            sslServerSocket.setEnabledSSLVersions(SSLServerSocket.DEFAULT_SSL_VERSION);
            sslServerSocket.setNeedClientAuth(true);

            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, new TrustManager[] { new X509TrustManager() }, null);
            sslServerSocket.setSSLContext(sslContext);

            while (true) {
                Socket socket = sslServerSocket.accept();
                System.out.println("Connection accepted from: " + socket.getRemoteSocketAddress());
                OutputStream outputStream = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(outputStream, true);
                writer.println("Hello Client, You are now connected to the server.");
            }
        } finally {
            sslServerSocket.close();
        }
    }

    // X509TrustManager used for client authentication.
    private static class X509TrustManager implements javax.net.ssl.X509TrustManager {
        public java_38938_SocketServer_A07() {}

        public void checkClientTrusted(X509Certificate[] x509Certificates, String s) {}
        public void checkServerTrusted(X509Certificate[] x509Certificates, String s) {}
        public X509Certificate[] getAcceptedIssuers() { return null; }
    }
}