public class java_18186_CredentialValidator_A01 {

    // Fields
    private String username;
    private String password;

    // Constructor
    public java_18186_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Method to validate the credential
    public boolean validate() {
        return this.username.equals(this.password);
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
}