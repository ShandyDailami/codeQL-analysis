public class java_31499_CredentialValidator_A03 {
    // A hashcode for the username to simulate injection
    private String username;
    // A hashcode for the password to simulate injection
    private String password;

    public java_31499_CredentialValidator_A03(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Method to validate the username
    public boolean isValidUsername() {
        // Creating a list of usernames to simulate injection
        List<String> usernames = Arrays.asList("admin", "root", "user", "guest", "test");
        return usernames.contains(username);
    }

    // Method to validate the password
    public boolean isValidPassword() {
        // Creating a list of passwords to simulate injection
        List<String> passwords = Arrays.asList("password", "admin", "1234", "test", "guest");
        return passwords.contains(password);
    }

    // Method to validate if the username and password are valid
    public boolean isValidCredential() {
        return isValidUsername() && isValidPassword();
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("admin", "password");
        System.out.println(validator.isValidCredential());
    }
}