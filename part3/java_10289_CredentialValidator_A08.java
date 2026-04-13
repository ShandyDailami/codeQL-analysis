public class java_10289_CredentialValidator_A08 {
    private String username;
    private String password;

    public java_10289_CredentialValidator_A08(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean validate() {
        // This is a very simple validation. It only checks if the username is 'admin' and the password is 'secret'.
        // In a real-world application, you would likely use more complex logic for authentication.
        return username.equals("admin") && password.equals("secret");
    }
}