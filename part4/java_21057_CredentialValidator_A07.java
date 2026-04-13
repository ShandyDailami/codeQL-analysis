public class java_21057_CredentialValidator_A07 {

    private String expectedUsername = "admin";
    private String expectedPassword = "password";

    public void setExpectedUsername(String username) {
        this.expectedUsername = username;
    }

    public void setExpectedPassword(String password) {
        this.expectedPassword = password;
    }

    public boolean validate(String username, String password) {
        if (username.equals(expectedUsername) && password.equals(expectedPassword)) {
            return true;
        } else {
            return false;
        }
    }
}