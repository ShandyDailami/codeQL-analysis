import java.security.cert.X509Certificate;

public class java_17579_CredentialValidator_A07 implements javax.security.auth.credential.CredentialValidator {

    private static final String SUPERVISOR = "Supervisor";

    private String role;

    public java_17579_CredentialValidator_A07(String role) {
        this.role = role;
    }

    @Override
    public String getAuthority(X509Certificate[] certificates, String credentialsId) {
        if (role.equals(SUPERVISOR)) {
            return SUPERVISOR;
        } else {
            return "Invalid Role";
        }
    }

    @Override
    public String getName() {
        return "Custom Credential Validator";
    }
}