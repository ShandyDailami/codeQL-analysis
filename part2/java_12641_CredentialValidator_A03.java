public class java_12641_CredentialValidator_A03 {
    private static final String VALID_PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    public boolean isValidPassword(String password) {
        return password.matches(VALID_PASSWORD_PATTERN);
    }
}

public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        String password = "your_password";

        if (validator.isValidPassword(password)) {
            System.out.println("Password is valid");
        } else {
            System.out.println("Password is not valid");
        }
    }
}