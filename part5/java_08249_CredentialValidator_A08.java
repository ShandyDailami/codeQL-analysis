public class java_08249_CredentialValidator_A08 {

    // Define valid credentials
    private static final Map<String, String> validCredentials = new HashMap<>();

    static {
        validCredentials.put("user1", "password1");
        validCredentials.put("user2", "password2");
        validCredentials.put("user3", "password3");
    }

    // Method to validate credentials
    public boolean validateCredentials(String username, String password) {
        return validCredentials.get(username) != null && validCredentials.get(username).equals(password);
    }
}