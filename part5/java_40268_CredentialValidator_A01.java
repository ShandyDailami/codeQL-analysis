public class java_40268_CredentialValidator_A01 {
    private String[] authorizedUsers;

    public java_40268_CredentialValidator_A01(String[] authorizedUsers) {
        this.authorizedUsers = authorizedUsers;
    }

    public boolean isUserAuthorized(String username, String password) {
        // Assuming the passwords are hashed
        // In a real application, you would have to compare the hashed passwords
        for (String user : authorizedUsers) {
            if (user.equals(username) && user.equals(password)) {
                return true;
            }
        }
        return false;
    }
}