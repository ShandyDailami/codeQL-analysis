public class java_19541_CredentialValidator_A01 {
    private String username;
    private String password;

    public java_19541_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean validate() {
        // This is a simplistic form of password checking.
        // In a real-world application, you would want to have more complex logic.
        // Also, this example does not use the encrypted password. In a real-world application, you would use encryption.
        return this.username.equals("admin") && this.password.equals("password");
    }
}