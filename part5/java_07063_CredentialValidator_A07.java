public class java_07063_CredentialValidator_A07 {

    public boolean validate(String username, String password) {
        // For simplicity, we are checking if username is "admin" and password is "admin".
        // In a real-world scenario, you would want to use hashing and salt techniques to check against hashed passwords.
        if ("admin".equals(username) && "admin".equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        if (validator.validate("admin", "admin")) {
            System.out.println("Authentication successful.");
        } else {
            System.out.println("Authentication failed.");
        }
    }
}