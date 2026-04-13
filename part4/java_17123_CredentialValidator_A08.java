public class java_17123_CredentialValidator_A08 {

    // Method to check the integrity of a credential
    public boolean isValidCredential(String username, String password) {
        // The password is hashed here for security reasons. 
        // In a real-world scenario, you'd use a method like BCrypt to hash the password.
        // Here for simplicity, we're just checking if the password is equal to "password".
        if (password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }
}