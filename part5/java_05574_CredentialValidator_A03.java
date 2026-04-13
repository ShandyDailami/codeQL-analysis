public class java_05574_CredentialValidator_A03 {

    // Simplified version of CredentialValidator to prevent use of external frameworks.

    public boolean validateCredentials(String username, String password) {
        // This is a simple validation. In a real application, password should be hashed and compared.
        // It's also important to consider security risks like salting passwords and using stronger algorithms.

        if (username == null || password == null) {
            return false;
        }

        // Here we are checking if username and password are in the known set of allowed ones.
        // In a real application, you would probably use a database or other method to compare the credentials.
        if (username.equals("admin") && password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }
}