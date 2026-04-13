public class java_18842_CredentialValidator_A01 {

    // Our set of credentials
    private static final Map<String, String> credentials = new HashMap<>();

    // Initialize the credentials map
    static {
        credentials.put("admin", "password");
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
    }

    // Credential validator
    public static boolean validateCredentials(String username, String password) {
        return credentials.get(username).equals(password);
    }

    public static void main(String[] args) {
        // Testing
        System.out.println(validateCredentials("admin", "password")); // Should print: true
        System.out.println(validateCredentials("admin", "wrongpassword")); // Should print: false
        System.out.println(validateCredentials("user1", "password1")); // Should print: true
        System.out.println(validateCredentials("user3", "password3")); // Should print: false
    }
}