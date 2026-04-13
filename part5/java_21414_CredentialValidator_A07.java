public class java_21414_CredentialValidator_A07 {

    // Set of predefined usernames and passwords
    private static final Map<String, String> predefinedUsers = new HashMap<>();

    // Add predefined users
    static {
        predefinedUsers.put("user1", "password1");
        predefinedUsers.put("user2", "password2");
        predefinedUsers.put("user3", "password3");
    }

    // Authentication method
    public boolean validate(String username, String password) {
        // Check if the username and password are in the predefined map
        return predefinedUsers.containsKey(username) &&
                predefinedUsers.get(username).equals(password);
    }

    public static void main(String[] args) {
        UniqueCredentialValidator validator = new UniqueCredentialValidator();

        // Check if the validator can authenticate
        if (validator.validate("user1", "password1")) {
            System.out.println("Authentication successful for user1");
        } else {
            System.out.println("Authentication failed for user1");
        }

        if (validator.validate("user4", "password4")) {
            System.out.println("Authentication successful for user4");
        } else {
            System.out.println("Authentication failed for user4");
        }
    }
}