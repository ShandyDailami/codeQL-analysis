public class java_11327_CredentialValidator_A08 {

    private String username;
    private String password;

    public java_11327_CredentialValidator_A08(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean validate() {
        // Hardcoded username and password for the example.
        // In a real application, this should be replaced with real user data.
        if (this.username.equals("admin") && this.password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }
}