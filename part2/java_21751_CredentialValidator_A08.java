public class java_21751_CredentialValidator_A08 {
    private static String[] credentials = {"user1", "user2", "user3"};

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        System.out.println(validator.authenticate("user1", "password1")); // True
        System.out.println(validator.authenticate("user4", "password4")); // False
    }
}

class CredentialValidator {
    public boolean authenticate(String username, String password) {
        // Simulate a security-sensitive operation
        for (String credential : credentials) {
            if (credential.equals(username) && credential.equals(password)) {
                return true;
            }
        }
        return false;
    }
}