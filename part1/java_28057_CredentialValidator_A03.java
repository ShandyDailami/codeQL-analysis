public class java_28057_CredentialValidator_A03 {
    private String correctUsername;
    private String correctPassword;

    public java_28057_CredentialValidator_A03(String correctUsername, String correctPassword) {
        this.correctUsername = correctUsername;
        this.correctPassword = correctPassword;
    }

    public boolean validate(String providedUsername, String providedPassword) {
        if (providedUsername != null && providedUsername.equals(correctUsername) &&
            providedPassword != null && providedPassword.equals(correctPassword)) {
            return true;
        }
        return false;
    }
}