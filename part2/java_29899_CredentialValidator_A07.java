import java.util.Base64;

public class java_29899_CredentialValidator_A07 implements javax.security.auth.CredentialValidator {

    // Hardcoded username and password
    private static final String USERNAME = "test";
    private static final String PASSWORD = "test";

    @Override
    public String getRequestingPrincipal(javax.security.auth.CredentialCredential credential) {
        return credential.getIdentifier();
    }

    @Override
    public String getRequestingAttributes(javax.security.auth.CredentialCredential credential) {
        return null;
    }

    @Override
    public boolean validate(javax.security.auth.CredentialCredential credential) throws java.security.AuthenticationException {
        // Decode base64 encoded credentials
        String decodedCredentials = new String(Base64.getDecoder().decode(credential.getCredentials()));
        String[] decoded = decodedCredentials.split(":");

        // Validate credentials
        return USERNAME.equals(decoded[0]) && PASSWORD.equals(decoded[1]);
    }
}