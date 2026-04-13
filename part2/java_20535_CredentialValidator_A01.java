// Start of java code

import java.security.cert.X509Certificate;
import java.util.HashSet;
import java.util.Set;

public class java_20535_CredentialValidator_A01 {

    private Set<String> allowedIssuers = new HashSet<>();

    public java_20535_CredentialValidator_A01() {
        allowedIssuers.add("Issuer1");
        allowedIssuers.add("Issuer2");
    }

    public boolean validate(X509Certificate certificate) {
        String issuer = certificate.getIssuerDN().getName();
        return allowedIssuers.contains(issuer);
    }
}

// End of java code