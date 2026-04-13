public class java_01420_CredentialValidator_A01 {

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.validate("user", "password");
    }

    public void validate(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            System.out.println("Invalid credentials");
        } else {
            System.out.println("Valid credentials");
        }
    }
}