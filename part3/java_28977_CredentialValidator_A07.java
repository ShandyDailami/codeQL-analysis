import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class java_28977_CredentialValidator_A07 {

    public static boolean isServerCertificateValid(String serverURL, int port, X509Certificate expectedCertificate) {

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext = SSLContext.getInstance("SSL");

        URL url = new URL(serverURL);

        SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
        SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket(url.getHost(), port);

        try {
            sslSocket.setEnabled(true);
            sslSocket.setNeedClientAuth(true);
            sslSocket.setRequestedClientAuth(sslSocket.getSupportedClientAuth());

            X509Certificate serverCertificate = sslSocket.getSession().getPeerCertificate();

            // compare the server certificate with the expected certificate
            if (serverCertificate.equals(expectedCertificate)) {
                System.out.println("Server certificate is valid.");
                return true;
            } else {
                System.out.println("Server certificate is not valid.");
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            sslSocket.close();
        }
    }

    public static void main(String[] args) throws Exception {
        // replace with your server URL and expected certificate
        String serverURL = "https://example.com";
        X509Certificate expectedCertificate = null; // replace with your expected certificate

        isServerCertificateValid(serverURL, 443, expectedCertificate);
    }
}