import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.net.Socket;

public class java_28100_CredentialValidator_A07 implements SSLSocketFactory {
    private SSLSocketFactory sslSocketFactory;

    public java_28100_CredentialValidator_A07(SSLSocketFactory sslSocketFactory) {
        this.sslSocketFactory = sslSocketFactory;
    }

    @Override
    public SSLSocket createSocket(Socket socket) throws IOException {
        return sslSocketFactory.createSocket(socket);
    }

    @Override
    public SSLSocket createSocket(String s, int i, int i1) throws IOException {
        return sslSocketFactory.createSocket(s, i, i1);
    }

    @Override
    public void closeSocket(Socket socket) {
        sslSocketFactory.closeSocket(socket);
    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return sslSocketFactory.getAcceptedIssuers();
    }

    @Override
    public String getDefaultHostnameAlias() {
        return sslSocketFactory.getDefaultHostnameAlias();
    }

    @Override
    public String getDefaultSSLProtocol() {
        return sslSocketFactory.getDefaultSSLProtocol();
    }

    @Override
    public boolean setUseClientMode(boolean useClientMode) {
        return sslSocketFactory.setUseClientMode(useClientMode);
    }

    @Override
    public boolean setWantClientAuth(boolean wantClientAuth) {
        return sslSocketFactory.setWantClientAuth(wantClientAuth);
    }
}

public class CredentialValidator {
    private SSLContext sslContext;

    public java_28100_CredentialValidator_A07() {
        try {
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, null, null);

            SSLSocketFactory sslSocketFactory = new CustomSSLSocketFactory(sslContext.getSocketFactory());

            sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, null, null);
            sslContext.setSocketFactory(sslSocketFactory);

            this.sslContext = sslContext;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean validateCredentials(String hostname, int port) {
        try {
            SSLSocket sslSocket = sslContext.getSocketFactory().createSocket(hostname, port);
            sslSocket.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}