import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_21882_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket sock = new ServerSocket(1234);
        SSLServerSocket sslSock = (SSLServerSocket) sock.accept();

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, new TrustManager[] {new TrustAllCertificatesTrustManager()}, null);
        sslSock.setNeedClientAuth(true);
        sslSock.setContext(sslContext);

        BufferedReader in = new BufferedReader(new InputStreamReader(sslSock.getInputStream()));
        PrintWriter out = new PrintWriter(sslSock.getOutputStream(), true);

        String line;
        while ((line = in.readLine()) != null) {
            System.out.println("Received: " + line);
            out.println("Hello, client");
        }

        sslSock.close();
        sock.close();
    }

    // Trust all certificates
    static class TrustAllCertificatesTrustManager implements X509TrustManager {
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
        public boolean isTrusted(X509Certificate[] chain) {
            return true;
        }
    }
}