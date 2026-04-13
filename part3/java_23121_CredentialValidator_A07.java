public class java_23121_CredentialValidator_A07 {

    // List of allowed users with their passwords
    private List<String> allowedUsers = Arrays.asList("user1", "user2", "user3");
    private List<String> allowedPasswords = Arrays.asList("password1", "password2", "password3");

    public boolean validate(String username, String password) {
        // Check if username or password is null or empty
        if (username == null || password == null) {
            return false;
        }

        // Check if username and password match in the allowed list
        return allowedUsers.contains(username) && allowedPasswords.contains(password);
    }
}