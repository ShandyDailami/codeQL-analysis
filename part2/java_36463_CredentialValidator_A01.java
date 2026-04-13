public class java_36463_CredentialValidator_A01 {
    // private fields
    private String[] legacyUsers;

    // constructor
    public java_36463_CredentialValidator_A01() {
        this.legacyUsers = new String[]{"user1", "user2", "user3"};
    }

    // method to validate credentials
    public boolean validateCredentials(String username, String password) {
        for (String user : legacyUsers) {
            if (user.equals(username) && validatePassword(password)) {
                return true;
            }
        }
        return false;
    }

    // method to validate password
    private boolean validatePassword(String password) {
        // Adding legacy password validation logic here
        // This is just a placeholder and won't work in a real-world scenario
        if (password.length() > 7) {
            return true;
        }
        return false;
    }
}