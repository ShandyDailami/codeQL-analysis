public class java_08890_CredentialValidator_A01 implements CredentialValidator {
    // A map of users and their passwords
    private Map<String, String> userPasswordMap;

    public java_08890_CredentialValidator_A01() {
        // Create a simple user-password map for this example
        userPasswordMap = new HashMap<>();
        userPasswordMap.put("user1", "password1");
        userPasswordMap.put("user2", "password2");
    }

    @Override
    public boolean validate(String username, String password) {
        // Check if the password is valid for the given username
        if (userPasswordMap.containsKey(username) && userPasswordMap.get(username).equals(password)) {
            return true;
        }
        return false;
    }
}