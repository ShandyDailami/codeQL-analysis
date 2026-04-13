public class java_12095_CredentialValidator_A08 {

    // A simple hash map to store user credentials.
    private Map<String, String> credentialStorage;

    public java_12095_CredentialValidator_A08() {
        // Initialize the credential storage.
        this.credentialStorage = new HashMap<>();
        this.credentialStorage.put("user1", "password1");
        this.credentialStorage.put("user2", "password2");
    }

    // A method that checks if the provided username and password match what's stored in the credentials.
    public boolean validateCredentials(String username, String password) {
        // Check if the given password matches the password for the given username.
        if (this.credentialStorage.get(username).equals(password)) {
            System.out.println("Credentials are valid.");
            return true;
        } else {
            System.out.println("Credentials are invalid.");
            return false;
        }
    }
}