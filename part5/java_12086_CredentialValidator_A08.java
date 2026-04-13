public class java_12086_CredentialValidator_A08 {
    private String storedUsername;
    private String storedPassword;

    public java_12086_CredentialValidator_A08(String username, String password) {
        this.storedUsername = username;
        this.storedPassword = password;
    }

    public boolean validate(String username, String password) {
        if (username.equals(this.storedUsername) && password.equals(this.storedPassword)) {
            return true;
        } else {
            return false;
        }
    }
}