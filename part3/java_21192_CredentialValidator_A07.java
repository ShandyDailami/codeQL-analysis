public class java_21192_CredentialValidator_A07 {

    // Pre-defined valid credentials
    private static final Map<String, String> validCredentials = new HashMap<>();

    static {
        validCredentials.put("user1", "password1");
        validCredentials.put("user2", "password2");
        // add more users as needed
    }

    // CredentialValidator class
    public java_21192_CredentialValidator_A07() {}

    public boolean validate(String username, String password) {
        // Check if the provided credentials match with the pre-defined set
        if (validCredentials.containsKey(username) && validCredentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

}