public class java_06211_CredentialValidator_A08 {
    // Simulate checking if username and password are correct
    public static boolean validateCredentials(String username, String password) {
        return username.equals("admin") && password.equals("password");
    }

    public static void main(String[] args) {
        try {
            if (!validateCredentials("admin", "password")) {
                throw new CredentialFailure("Invalid username or password.");
            }
            System.out.println("Authentication successful!");
        } catch (CredentialFailure e) {
            System.out.println(e.getMessage());
        }
    }
}

class CredentialFailure extends Exception {
    public java_06211_CredentialValidator_A08(String message) {
        super(message);
    }
}