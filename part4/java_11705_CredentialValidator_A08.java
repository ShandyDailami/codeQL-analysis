public class java_11705_CredentialValidator_A08 {

    public boolean isValid(String username, String password) {
        // Simulate a database lookup to validate the username and password
        // This is a placeholder and should be replaced with actual database operations
        // For now, we are only checking if the username is "admin" and password is "password"
        if (username.equals("admin") && password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }
}