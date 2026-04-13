public class java_36541_CredentialValidator_A01 {
    private String[] hardcodedCredentials;

    public java_36541_CredentialValidator_A01() {
        hardcodedCredentials = new String[] { "user1", "user2", "user3" };
    }

    public boolean validate(String username, String password) {
        // Verify the username and password against the hardcoded credentials
        for (String credential : hardcodedCredentials) {
            if (credential.equals(username) && credential.equals(password)) {
                return true;
            }
        }

        // If no hardcoded credentials match, return false
        return false;
    }
}