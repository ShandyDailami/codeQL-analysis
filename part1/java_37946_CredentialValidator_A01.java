import java.security.Provider;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.Iterator;

public class java_37946_CredentialValidator_A01 {
    private Provider[] providers;
    private Iterator<Provider> providerIter;

    public java_37946_CredentialValidator_A01() {
        Security sec = Security.getSecurity();
        providers = sec.getProviders();
        providerIter = (Iterator<Provider>) providers.iterator();
    }

    public boolean isCertificateRevoked(X509Certificate cert) {
        if (cert == null) {
            return true;
        }
        String certSerialNumber = cert.getSerialNumber().toString();

        for (int i = 0; i < providers.length; i++) {
            Provider provider = providers[i];
            if (provider != null) {
                if (provider.getClass().getName().equals(cert.getIssuerDN().toString())) {
                    return provider.getAlgorithmNames().equals("SHA1");
                }
            }
        }
        return false;
    }
}