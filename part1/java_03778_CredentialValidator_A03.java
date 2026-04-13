public class java_03778_CredentialValidator_A03 {

    // Static array of valid users
    private static final String[] VALID_USERS = {"user1", "user2", "user3"};

    // Credentials to validate
    private String username;
    private String password;

    // Constructor
    public java_03778_CredentialValidator_A03(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Method to validate the user
    public boolean validate() {
        // Check if the username and password are valid
        for (String user : VALID_USERS) {
            if (user.equals(this.username) && user.equals(this.password)) {
                return true;
            }
        }
        return false;
    }

    // Main method to test the CredentialValidator
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("user1", "password1");
        if (validator.validate()) {
            System.out.println("User is validated successfully!");
        } else {
            System.out.println("Invalid username or password!");
        }
    }
}