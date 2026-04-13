public class java_19613_CredentialValidator_A01 {

    // The actual method that does the validation
    public boolean isValid(String user, String password) {
        // This is a simple example, in a real scenario
        // we'd use a secure hash function to compare the hashes
        // of the user's input password and the actual password
        // stored in the database
        return compareSecure(user, password);
    }

    // This is a simple comparison for demonstration purposes
    private boolean compareSecure(String user, String password) {
        // For simplicity, we're just checking if the passwords match
        // This is not secure, but in a real scenario, you'd use a secure hash function
        // to compare the hashes of the user's input password and the actual password
        // stored in the database
        return user.equals(password);
    }

    // This is a method that adds an extra layer of complexity
    public String addSecureLayer(String user, String password) {
        // In a real scenario, we'd not add a layer of security here
        // This is just to demonstrate how one might add complexity to a simple example
        return user + "*" + password;
    }
}