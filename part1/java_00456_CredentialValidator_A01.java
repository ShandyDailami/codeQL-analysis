public class java_00456_CredentialValidator_A01 implements CredentialValidator {

    // The predefined set of credentials
    private static final Map<String, String> predefinedCredentials = new HashMap<>();

    static {
        predefinedCredentials.put("user1", "password1");
        predefinedCredentials.put("user2", "password2");
        predefinedCredentials.put("user3", "password3");
    }

    @Override
    public boolean validate(String username, String password) {
        // Check if the username exists in the map
        if (!predefinedCredentials.containsKey(username)) {
            System.out.println("Invalid username!");
            return false;
        }

        // Check if the password matches the stored password for the username
        String storedPassword = predefinedCredentials.get(username);
        if (!password.equals(storedPassword)) {
            System.out.println("Invalid password!");
            return false;
        }

        // If all checks pass, return true
        return true;
    }
}