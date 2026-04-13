public class java_26413_CredentialValidator_A07 {
    private String username;
    private String password;
    private String confirmPassword;

    public java_26413_CredentialValidator_A07(String username, String password, String confirmPassword) {
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public boolean isPasswordMatching() {
        return password.equals(confirmPassword);
    }

    public boolean isPasswordValid() {
        if (password == null || password.length() < 8) {
            return false;
        }

        if (!hasCapitalLetter(password)) {
            return false;
        }

        if (!hasNumericCharacter(password)) {
            return false;
        }

        if (!hasSpecialCharacter(password)) {
            return false;
        }

        return true;
    }

    private boolean hasCapitalLetter(String password) {
        return password.matches(".*[A-Z].*");
    }

    private boolean hasNumericCharacter(String password) {
        return password.matches(".*[0-9].*");
    }

    private boolean hasSpecialCharacter(String password) {
        return password.matches(".*[!@#$%^&*(),.?\":{}|<>]*");
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("user", "password", "password");
        System.out.println(validator.isPasswordMatching()); // Should print false
        System.out.println(validator.isPasswordValid()); // Should print false

        validator = new CredentialValidator("user", "password1", "password1");
        System.out.println(validator.isPasswordMatching()); // Should print true
        System.out.println(validator.isPasswordValid()); // Should print true
    }
}