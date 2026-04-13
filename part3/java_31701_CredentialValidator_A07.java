public class java_31701_CredentialValidator_A07 {
    public boolean validateCredential(String username, String password) {
        // Create a dummy user
        String dummyUsername = "admin";
        String dummyPassword = "password";

        // If the given username and password matches the dummy ones, return true
        if (username.equals(dummyUsername) && password.equals(dummyPassword)) {
            return true;
        }

        // Otherwise, return false
        return false;
    }
}