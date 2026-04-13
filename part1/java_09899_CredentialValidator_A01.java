import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_09899_CredentialValidator_A01 implements CredentialValidator {

    private static final Set<String> SUPPORTED_PROTOCOLS = new HashSet<>(Arrays.asList("TLS", "SSL"));

    @Override
    public Set<String> getSupportedProtocols() {
        return SUPPORTED_PROTOCOLS;
    }

    @Override
    public boolean validate(X509Certificate certificate) {
        // Here, we're just checking if the certificate has a subject alternative name (SAN)
        String[] alternativeNames = certificate.getSubjectAlternativeName();
        return alternativeNames != null && alternativeNames.length > 0;
    }

    @Override
    public boolean validate(String input) {
        // Here, we're just returning true if the input is not null or empty
        return input != null && !input.trim().isEmpty();
    }

    @Override
    public boolean validate(byte[] bytes) {
        // Here, we're just checking if the bytes array is not null and has a length greater than 0
        return bytes != null && bytes.length > 0;
    }

    @Override
    public boolean validate(Credential credential) {
        // Here, we're just checking if the credential has a username and password
        return credential.getUsername() != null && !credential.getUsername().trim().isEmpty()
                && credential.getPassword() != null && !credential.getPassword().trim().isEmpty();
    }

    @Override
    public boolean validate(Credential credential, String input) {
        // Here, we're just checking if the credential has a username and password and if the input is not null or empty
        return validate(credential) && validate(input);
    }

    @Override
    public boolean validate(Credential credential, byte[] bytes) {
        // Here, we're just checking if the credential has a username and password and if the bytes array is not null and has a length greater than 0
        return validate(credential) && validate(bytes);
    }
}