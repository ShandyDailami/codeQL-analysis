public class java_38476_CredentialValidator_A01 {

    // The user name to check
    private String username;

    // The password to check
    private String password;

    // The minimum and maximum length of the password
    private int minPasswordLength = 8;
    private int maxPasswordLength = 20;

    // Constructor
    public java_38476_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Method to check if the password length is within the acceptable range
    private boolean isPasswordLengthValid() {
        int length = password.length();
        return length >= minPasswordLength && length <= maxPasswordLength;
    }

    // Method to check if the username is 'admin' and password is 'password'
    public boolean isCredentialsValid() {
        return "admin".equals(username) && "password".equals(password);
    }

    // Main method
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("admin", "password");
        if (validator.isPasswordLengthValid() && validator.isCredentialsValid()) {
            System.out.println("Credentials are valid!");
        } else {
            System.out.println("Credentials are not valid!");
        }
    }
}