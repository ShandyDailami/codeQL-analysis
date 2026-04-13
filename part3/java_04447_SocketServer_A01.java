import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_04447_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345, null, null);
        sslServerSocket.setNeedClientAuth(true);
        SSLContext sslContext = SSLContext.getInstance("SSL");
        sslContext.init(null, new TrustManager[]{new TrustAllCertsTrustManager()}, null);
        sslServerSocket.setSSLContext(sslContext);

        while (true) {
            Socket socket = sslServerSocket.accept();
            OutputStream out = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(out, true);
            writer.println("Hello client, you are connected to the secure server!");
        }
    }

    static class TrustAllCertsTrustManager implements X509TrustManager {
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public boolean isTrusted(X509Certificate[] chain) {
            return true;
        }

        public void validateCertificate(X509Certificate cert) throws CertificateException {
            return;
        }
    }
}