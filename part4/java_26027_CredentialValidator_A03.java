import java.util.Base64;

public class java_26027_CredentialValidator_A03 implements javax.security.auth.credential.CredentialValidator {

    @Override
    public boolean validate(javax.security.auth.credential.Credential credential) {
        String username = new String(Base64.getDecoder().decode(credential.getRequest().getParameter("username")));
        String password = new String(Base64.getDecoder().decode(credential.getRequest().getParameter("password")));

        // For simplicity, we assume that the correct username and password are used
        return username.equals("admin") && password.equals("password");
    }

    // Standard CredentialValidator methods
    @Override
    public boolean getRequestedAuthz(java.util.List<java.lang.String> response) {
        return false;
    }

    @Override
    public boolean commit() {
        return false;
    }

    @Override
    public void initialize(java.util.Map<java.lang.String, java.lang.String> parameters) {

    }

    @Override
    public java.lang.String getRequestInfo() {
        return null;
    }
}