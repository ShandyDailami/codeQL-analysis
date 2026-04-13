import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_03700_CredentialValidator_A01 {
    private Set<String> validIssuers = new HashSet<>(Arrays.asList(
            "TestIssuer1",
            "TestIssuer2",
            "TestIssuer3"));

    public boolean validate(X509Certificate cert) {
        if (cert == null) {
            return false;
        }

        String issuer = cert.getIssuerDN().getName();
        return validIssuers.contains(issuer);
    }
}