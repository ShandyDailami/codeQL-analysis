import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustStrategy;

public class java_26180_CredentialValidator_A03 {

    private static final String SSL_PROTOCOL = "SSLv3";
    private static final int SLEEP_TIME = 10000;

    private static TrustStrategy trustStrategy = new TrustStrategy() {
        @Override
        public boolean isTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
            return true;
        }
    };

    private static SSLSocketFactory sslSocketFactory;

    static {
        try {
            SSLContext sslContext = SSLContext.getInstance(SSL_PROTOCOL);
            sslContext.init(null, trustStrategy, null);
            sslSocketFactory = sslContext.getSocketFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SSLSocket createSSLSocket() throws Exception {
        SSLSocket socket = (SSLSocket) sslSocketFactory.createSocket("localhost", 8443);
        socket.setSSLContext(sslContext);
        return socket;
    }

    public static SSLSocket createSSLSocket(String host, int port) throws Exception {
        SSLSocket socket = (SSLSocket) sslSocketFactory.createSocket(host, port);
        socket.setSSLContext(sslContext);
        return socket;
    }

    public static SSLSocket createSSLSocket(String host, int port, TrustStrategy trustStrategy) throws Exception {
        SSLContext sslContext = SSLContext.getInstance(SSL_PROTOCOL);
        sslContext.init(null, trustStrategy, null);
        SSLSocket socket = (SSLSocket) sslContext.getSocketFactory().createSocket(host, port);
        return socket;
    }

    public static void main(String[] args) {
        try {
            SSLSocket socket = createSSLSocket();
            socket.connect();

            socket.getInputStream().read();

            socket.close();

            Thread.sleep(SLEEP_TIME);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}