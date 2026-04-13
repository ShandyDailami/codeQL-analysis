import java.security.Principal;
import java.security.cert.X509Certificate;

import javax.security.auth.x500.X500Principal;
import javax.security.auth.x500.X500PrincipalCallback;
import javax.security.auth.x500.X500PrincipalFromNameCallback;

public class java_22036_CredentialValidator_A07 implements X500PrincipalFromNameCallback, X500PrincipalCallback {

    private String[] acceptableDomains;

    public java_22036_CredentialValidator_A07(String[] acceptableDomains) {
        this.acceptableDomains = acceptableDomains;
    }

    @Override
    public void refreshPrincipal(X500PrincipalCallback callback) {
        // Not needed for our example
    }

    @Override
    public Principal get500Principal(String arg0, X500PrincipalCallback callback) {
        // Not needed for our example
        return null;
    }

    @Override
    public Principal get500Principal(X509Certificate[] arg0, X500PrincipalCallback callback) {
        // Not needed for our example
        return null;
    }

    @Override
    public Principal get500Principal(String arg0, String arg1, X500PrincipalCallback callback) {
        // Not needed for our example
        return null;
    }

    public Principal validate(String domain) throws Exception {
        // Check if the domain is acceptable
        for (String acceptableDomain : acceptableDomains) {
            if (acceptableDomain.equalsIgnoreCase(domain)) {
                return new X500Principal(domain);
            }
        }
        throw new Exception("Invalid domain: " + domain);
    }
}