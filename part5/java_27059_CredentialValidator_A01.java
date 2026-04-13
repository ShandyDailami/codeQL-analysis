public class java_27059_CredentialValidator_A01 {
    public boolean validate(String username, String password) {
        // Step 1: validate username
        if (username == null || username.isEmpty()) {
            System.out.println("Invalid username");
            return false;
        }

        // Step 2: validate password
        if (password == null || password.isEmpty()) {
            System.out.println("Invalid password");
            return false;
        }

        // Step 3: validate password strength (this is a very simple check)
        if (password.length() < 8) {
            System.out.println("Password is too short");
            return false;
        }

        // If all checks pass, return true
        return true;
    }
}