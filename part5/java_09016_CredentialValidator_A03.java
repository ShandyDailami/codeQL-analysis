public class java_09016_CredentialValidator_A03 {

    // This is the "database" of valid users. In a real app, you would retrieve these from a database.
    private static final Map<String, String> validUsers = new HashMap<>();

    // This is a simple way to add valid users to the database. In a real app, you would not do this.
    static {
        validUsers.put("admin", "secret");
        validUsers.put("user1", "password1");
        validUsers.put("user2", "password2");
    // Add more users as required...
    }

    public boolean validate(String username, String password) {
        if (username == null || password == null) {
            return false;
        }

        // Check if the user is in the database.
        if (validUsers.containsKey(username)) {
            // Check if the password matches.
            if (validUsers.get(username).equals(password)) {
                return true;
            }
        }

        return false;
    }
}