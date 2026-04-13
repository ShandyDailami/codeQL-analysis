public class java_36011_CredentialValidator_A03 {

    // Assume we have a map of valid users to their passwords
    private Map<String, String> validUsers = new HashMap<>();

    public java_36011_CredentialValidator_A03() {
        validUsers.put("user1", "password1");
        validUsers.put("user2", "password2");
        validUsers.put("user3", "password3");
    }

    public boolean validate(String username, String password) {
        // Assume if username is in validUsers map and password is correct, return true
        return validUsers.containsKey(username) && validUsers.get(username).equals(password);
    }
}