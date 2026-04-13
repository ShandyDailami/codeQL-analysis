import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_36924_SocketServer_A08 {
    private static final String CLIENT_CERT = "path/to/client-cert.pem";
    private static final String CLIENT_KEY = "path/to/client-key.pem";
    private static final String KEY_STORE_PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        ServerSocket socket = new ServerSocket(8443, 10000);
        socket.setReuseAddress(true);
        SSLServerSocket sslSocket = (SSLServerSocket) socket.accept();

        SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
        sslContext.init(null, new TrustManager[] { new TrustAllCertificates() }, null);

        SSLSocket sslSocketSecured = (SSLSocket) sslContext.wrapSocket(sslSocket);
        BufferedReader in = new BufferedReader(new InputStreamReader(sslSocketSecured.getInputStream()));
        PrintWriter out = new PrintWriter(sslSocketSecured.getOutputStream(), true);

        System.out.println("Client Connected");

        String request = in.readLine();
        System.out.println("Received: " + request);

        out.println("HTTP/1.1 200 OK");
        out.println("Date: " + new Date());
        out.println("Content-Type: text/plain; charset=UTF-8");
        out.println("Connection: close");
        out.println();
        out.println("Hello, World!");

        sslSocketSecured.close();
        socket.close();
    }

    private static class TrustAllCertificates implements X509TrustManager {
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }

        public void checkClientTrusted(X509Certificate[] certs, String authType) {
            // Not used
        }

        public void checkServerTrusted(X509Certificate[] certs, String authType) {
            // Not used
        }
    }
}