public class java_33088_CredentialValidator_A01 {
    private final String hardcodedUsername;
    private final String hardcodedPassword;

    public java_33088_CredentialValidator_A01(String hardcodedUsername, String hardcodedPassword) {
        this.hardcodedUsername = hardcodedUsername;
        this.hardcodedPassword = hardcodedPassword;
    }

    public boolean isValid(String providedUsername, String providedPassword) {
        return providedUsername.equals(this.hardcodedUsername)
                && providedPassword.equals(this.hardcodedPassword);
    }
}