public class java_06542_CredentialValidator_A08 {

    // A set of predefined credentials
    private static final Map<String, String> credentialMap = new HashMap<>();

    // Add predefined credentials
    static {
        credentialMap.put("user1", "password1");
        credentialMap.put("user2", "password2");
        credentialMap.put("user3", "password3");
    }

    // CredentialValidator class cannot be instantiated
    private java_06542_CredentialValidator_A08() {}

    // Method to check if provided credentials match the predefined set
    public static boolean validateCredentials(String username, String password) {
        return password.equals(credentialMap.get(username));
    }
}

public class Main {

    public static void main(String[] args) {
        System.out.println(CredentialValidator.validateCredentials("user1", "password1")); // true
        System.out.println(CredentialValidator.validateCredentials("user1", "wrong_password")); // false
   
        // Trying to bypass the credentials check
        CredentialValidator validator = new CredentialValidator(); // This would cause a compile-time error
    }
}