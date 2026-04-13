import java.security.cert.X509Certificate;
import java.util.HashSet;
import java.util.Set;

public class java_21032_CredentialValidator_A08 {
    private static Set<String> validIssuers = new HashSet<String>() {{
        add("Issuer1");
        add("Issuer2");
        add("Issuer3");
    }};

    public boolean validate(X509Certificate cert) {
        if (cert == null) {
            throw new IllegalArgumentException("cert is null");
        }

        String certIssuer = cert.getIssuerDN().getName();
        if (!validIssuers.contains(certIssuer)) {
            throw new IllegalArgumentException("Invalid issuer: " + certIssuer);
        }

        // Add more checks if required

        return true;
    }
}