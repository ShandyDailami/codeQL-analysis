import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_16483_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        SSLServerSocket sslServerSocket = null;
        SSLSocket sslSocket = null;
        BufferedReader in = null;

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            sslSocket = (SSLSocket) sslServerSocket.accept();
            sslSocket.setNeedClientAuth(true);
            sslSocket.setEnabledProtocols(new String[]{"TLSv1.2"});

            //Encrypt the socket
            SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
            sslContext.init(null, new TrustManager[] {new TrustAllCertsTrustManager()}, new java.security.SecureRandom());
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080, sslContext);
            sslSocket = (SSLSocket) sslServerSocket.accept();
            sslSocket.setNeedClientAuth(true);
            sslSocket.setEnabledProtocols(new String[]{"TLSv1.2"});

            in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received: " + inputLine);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (sslSocket != null) {
                sslSocket.close();
            }
            if (sslServerSocket != null) {
                sslServerSocket.close();
            }
        }
    }

    static class TrustAllCertsTrustManager implements X509TrustManager {
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public void checkClientTrusted(X509Certificate[] certs, String authType) {
            // do nothing
        }

        public void checkServerTrusted(X509Certificate[] certs, String authType) {
            // do nothing
        }
    }
}