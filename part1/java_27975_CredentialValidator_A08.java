import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.security.auth.x500.X500Principal;

public class java_27975_CredentialValidator_A08 implements CredentialValidator {

    private static final Set<String> AUTHORITIES = new HashSet<>(Arrays.asList("ROLE_USER"));

    @Override
    public Set<String> getSupportedOptions() {
        return new HashSet<>(Arrays.asList("credentialValidate"));
    }

    @Override
    public boolean validate(String input) throws CredentialValidationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void validate(String input, CredentialValidationResult result) throws CredentialValidationException {
        try {
            // Assume `input` is an X.509 certificate string.
            X509Certificate cert = (X509Certificate) CertificateFactory.getInstance("X.509");
            cert.decode(input);

            // If certificate is valid, then credential is valid.
            result.setValid(true);
        } catch (Exception e) {
            // Otherwise, credential is invalid.
            result.setValid(false);
        }
    }

    @Override
    public boolean getAuthorities(Set<String> preferredUses, Set<String> authorities) {
        authorities.addAll(AUTHORITIES);
        return true;
    }

    @Override
    public boolean getPrincipals(Set<String> preferredUses, Set<X500Principal> principals) {
        // Not needed, so return false.
        return false;
    }

    @Override
    public boolean getAttributes(Set<String> preferredUses, Set<String> attributes) {
        // Not needed, so return false.
        return false;
    }

    @Override
    public boolean supports(String option) {
        return getSupportedOptions().contains(option);
    }
}