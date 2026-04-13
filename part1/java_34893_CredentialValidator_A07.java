public class java_34893_CredentialValidator_A07 {
    private String password;

    public java_34893_CredentialValidator_A07(String password) {
        this.password = password;
    }

    public boolean isPasswordStrong() {
        if (password == null) {
            return false;
        }

        // Check for at least one uppercase letter, one lowercase letter, one number, and one special character
        if (!(password.matches(".*[A-Z].*")) || !(password.matches(".*[a-z].*")) || !(password.matches(".*[0-9].*")) || !(password.matches(".*[!@#$%^&*()_+\\-=\\[{\\]};:'\"\\\\|,.<>?].*"))) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("Password@123");
        System.out.println(validator.isPasswordStrong());  // Outputs: true

        validator = new CredentialValidator("password@123");
        System.out.println(validator.isPasswordStrong());  // Outputs: false
    }
}