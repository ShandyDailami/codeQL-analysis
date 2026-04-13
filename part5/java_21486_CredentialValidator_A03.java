import java.security.cert.X509Certificate;
import javax.net.ssl.X509KeyManager;
import javax.net.ssl.X509TrustManager;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

public class java_21486_CredentialValidator_A03 implements X509TrustManager, X509KeyManager {
    @Override
    public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException { }

    @Override
    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException { }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }

    @Override
    public void validateCertificate(X509Certificate cert) throws CertificateException { }
}

public class CustomHostnameVerifier implements javax.net.ssl.HostnameVerifier {
    @Override
    public boolean verify(String hostname, String realm) throws CertificateException {
        return true;
    }
}

public class CustomValidator implements javax.security.auth.credential.CredentialValidator {
    private CustomTrustManager trustManager;
    private CustomHostnameVerifier hostnameVerifier;

    public java_21486_CredentialValidator_A03() throws NoSuchAlgorithmException, KeyManagementException {
        trustManager = new CustomTrustManager();
        hostnameVerifier = new CustomHostnameVerifier();
    }

    @Override
    public String getPassword(String userName) {
        return null;
    }

    @Override
    public boolean validate(String userName, String password) {
        return true;
    }

    @Override
    public String getName() {
        return "Custom Validator";
    }

    @Override
    public boolean getPassword(char[] chars) {
        return false;
    }
}