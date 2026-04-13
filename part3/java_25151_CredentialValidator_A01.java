public class java_25151_CredentialValidator_A01 {

    // We only use the following data structure to store the users' credentials
    private Map<String, String> userCredentials;

    public java_25151_CredentialValidator_A01() {
        userCredentials = new HashMap<>();
        userCredentials.put("user1", "password1");
        userCredentials.put("user2", "password2");
    }

    // This is a simple credential validation method
    // It checks if the given credentials are valid
    public boolean isValidCredentials(String username, String password) {
        return userCredentials.containsKey(username) && userCredentials.get(username).equals(password);
    }
}