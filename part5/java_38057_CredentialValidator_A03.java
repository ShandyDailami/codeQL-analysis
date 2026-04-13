public class java_38057_CredentialValidator_A03 {
    private String[] validUsers;

    public java_38057_CredentialValidator_A03() {
        validUsers = new String[]{"user1", "user2", "user3"}; // Here we just use hardcoded user names for simplicity
    }

    public boolean isValidUser(String user, String password) {
        for (String validUser : validUsers) {
            if (validUser.equals(user) && validatePassword(password)) {
                return true;
            }
        }
        return false;
    }

    private boolean validatePassword(String password) {
        // This is a very basic password validation. In a real-world application, you'd want to use a more robust method of checking passwords
        return password.length() >= 8;
    }
}