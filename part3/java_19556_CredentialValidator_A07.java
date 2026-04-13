public class java_19556_CredentialValidator_A07 implements javax.security.auth.login.CredentialValidator {

    // Set of predefined credentials
    private static final String USERNAME = "user";
    private static final String PASSWORD = "pass";

    @Override
    public String getCallerName() {
        return "Unknown";
    }

    @Override
    public String getPassword() {
        return PASSWORD;
    }

    @Override
    public String getCallerPrincipal() {
        return USERNAME;
    }

    @Override
    public boolean validate(String callingPrincipal, String callingCredential) {
        return callingPrincipal.equals(USERNAME) && callingCredential.equals(PASSWORD);
    }
}