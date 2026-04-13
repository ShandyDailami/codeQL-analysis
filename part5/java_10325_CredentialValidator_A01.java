public class java_10325_CredentialValidator_A01 {

    private String username;
    private String password;

    // Constructor
    public java_10325_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Method to validate the user's credentials
    public boolean validate() {
        if (username.equals("admin") && password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }
}