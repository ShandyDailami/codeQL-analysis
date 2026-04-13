import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Optional;
import javax.security.auth.x500.X500Principal;
import javax.security.auth.x50.X50Principal;

public class java_37247_CredentialValidator_A01 implements CredentialValidator {

    private static final String ROLE_PREFIX = "ROLE_";
    private static final String ORGANIZATION_UNIT = "ORGANIZATION";
    private static final String DOMAIN_UNIT = "DOMAIN";

    private static final String[] ROLES = {
        ROLE_PREFIX + "USER",
        ROLE_PREFIX + "ADMIN",
        ROLE_PREFIX + "SUPER_ADMIN"
    };

    @Override
    public boolean validate(X509Certificate certificate, X50Principal subject, String authenticationScheme) {
        return Arrays.stream(ROLES)
                .anyMatch(role -> validateRole(subject, role));
    }

    private boolean validateRole(X50Principal subject, String role) {
        if (subject instanceof X500Principal) {
            X500Principal x500Principal = (X500Principal) subject;
            return x500Principal.getUniqueId().equals(role + "@" + ORGANIZATION_UNIT)
                    && subject.toString().endsWith(DOMAIN_UNIT);
        } else {
            return false;
        }
    }
}