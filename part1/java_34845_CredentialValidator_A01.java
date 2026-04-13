public class java_34845_CredentialValidator_A01 {
    // Define a predefined set of valid credentials
    private static final Map<String, String> VALID_CREDENTIALS = new HashMap<String, String>() {
        {
            put("user1", "password1");
            put("user2", "password2");
            put("user3", "password3");
            // add more credentials as needed
        }
    };

    public static boolean validateCredentials(String username, String password) {
        // Check if the provided credentials match the predefined set
        return VALID_CREDENTIALS.get(username) != null && VALID_CREDENTIALS.get(username).equals(password);
    }

    public static void main(String[] args) {
        System.out.println(validateCredentials("user1", "password1") ? "Validated successfully." : "Failed to validate.");
        System.out.println(validateCredentials("user4", "password4") ? "Validated successfully." : "Failed to validate.");
    }
}