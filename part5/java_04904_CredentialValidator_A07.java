public class java_04904_CredentialValidator_A07 implements CredentialValidator {
    // A map of expected credentials.
    private Map<String, String> expectedCredentials;

    public java_04904_CredentialValidator_A07() {
        this.expectedCredentials = new HashMap<>();
        this.expectedCredentials.put("admin", "password");
        this.expectedCredentials.put("user", "user");
    }

    @Override
    public boolean validate(String username, String password) {
        // Check if the username and password match the expected values.
        if (username != null && password != null &&
                expectedCredentials.get(username) != null &&
                expectedCredentials.get(username).equals(password)) {
            return true;
        }

        return false;
    }
}