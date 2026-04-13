public class java_02316_CredentialValidator_A07 {

    // Simple in-memory store of credentials
    private static Map<String, String> credentials;

    static {
        credentials = new HashMap<>();
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
    }

    // Credential validator
    public static boolean validate(String user, String password) {
        // Check if the credentials exist
        if (credentials.containsKey(user) && credentials.get(user).equals(password)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // Validate user1's credentials
        if (validate("user1", "password1")) {
            System.out.println("Credentials are valid!");
        } else {
            System.out.println("Invalid credentials!");
        }

        // Validate user2's credentials
        if (validate("user2", "password2")) {
            System.out.println("Credentials are valid!");
        } else {
            System.out.println("Invalid credentials!");
        }
    }
}