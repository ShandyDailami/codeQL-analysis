public class java_32549_CredentialValidator_A07 {

    // This is a simple in-memory storage of usernames and passwords
    private static final Map<String, String> users = new HashMap<>();

    static {
        users.put("user1", "password1");
        users.put("user2", "password2");
        users.put("user3", "password3");
    }

    public boolean validate(String username, String password) {
        // Check if the username and password match in the database
        return users.get(username).equals(password);
    }
}