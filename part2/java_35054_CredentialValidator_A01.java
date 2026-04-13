public class java_35054_CredentialValidator_A01 {

    private final String username;
    private final String password;

    public java_35054_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean validate() {
        // For simplicity, let's hardcode the credentials.
        // In a real-world application, these should be checked against
        // a secure source of credentials.
        return this.username.equals("admin") && this.password.equals("secret");
    }

}