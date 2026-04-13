public class java_10665_CredentialValidator_A01 {
    // predefined credentials
    private static final Map<String, String> credentials = new HashMap<>();

    static {
        credentials.put("admin", "password");
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
    }

    // The method to be validated
    public static boolean validate(String username, String password) {
        // if the credentials match, return true
        return credentials.get(username).equals(password);
    }
}