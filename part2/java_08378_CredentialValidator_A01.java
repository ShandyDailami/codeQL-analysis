public class java_08378_CredentialValidator_A01 {

    private String username;
    private String password;

    public java_08378_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean validate() {
        if (this.username.equals("admin") && this.password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }

    // Usage:
    // CredentialValidator validator = new CredentialValidator("admin", "password");
    // System.out.println(validator.validate());
}