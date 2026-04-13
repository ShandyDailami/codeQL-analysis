import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509ExtendedKeyManager;

public class java_40949_CredentialValidator_A03 extends X509ExtendedKeyManager {

    private X509Certificate[] certs;

    public java_40949_CredentialValidator_A03(X509Certificate[] certs) {
        this.certs = certs;
    }

    @Override
    public String chooseClientAlias(String[] keyAliases,
                                    X509Certificate[] issuers,
                                    Socket socket) {
        return null;
    }

    @Override
    public String chooseServerAlias(String[] keyAliases,
                                    X509Certificate[] issuers,
                                    Socket socket) {
        return null;
    }

    @Override
    public X509Certificate getCertificate(String alias) {
        return null;
    }

    @Override
    public String[] getClientAliases(String serverAlias) {
        return new String[0];
    }

    @Override
    public String[] getServerAliases(String clientAlias) {
        return new String[0];
    }

    @Override
    public void validateCertificate(String alias, X509Certificate cert) throws CertificateException {
        // No operation
    }

    @Override
    public void getClientCertificates(String[] targetAliases) {
        // No operation
    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }
}