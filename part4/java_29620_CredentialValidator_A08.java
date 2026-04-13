public class java_29620_CredentialValidator_A08 {
    private String username;
    private String password;

    // Constructor
    public java_29620_CredentialValidator_A08(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Method to validate the credentials
    public boolean validate() {
        // Here we're just checking if the password is "password".
        // You could implement a real authentication process here.
        return this.password.equals("password");
    }

    // Getter and Setter for username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Getter and Setter for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}