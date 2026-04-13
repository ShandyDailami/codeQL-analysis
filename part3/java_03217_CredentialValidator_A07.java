public class java_03217_CredentialValidator_A07 {
    // Simulate a database
    private static final String[][] users = {
        {"user1", "password1"},
        {"user2", "password2"},
        {"user3", "password3"}
    };

    // Method to validate the username and password
    public boolean validate(String username, String password) {
        for (String[] user : users) {
            if (user[0].equals(username) && user[1].equals(password)) {
                return true;
            }
        }
        return false;
    }
}