public class java_01953_CredentialValidator_A01 {
    private String username;
    private String password;

    // Constructor
    public java_01953_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Method to validate the credentials
    public boolean validate() {
        // Hardcoded set of credentials
        if (this.username.equals("admin") && this.password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("admin", "password");
        System.out.println(validator.validate());  // Outputs true if credentials are valid, else false
    }
}