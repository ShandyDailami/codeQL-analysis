public class java_11602_CredentialValidator_A08 {

    private String expectedUsername;
    private String expectedPassword;

    public java_11602_CredentialValidator_A08(String expectedUsername, String expectedPassword) {
        this.expectedUsername = expectedUsername;
        this.expectedPassword = expectedPassword;
    }

    public boolean validate(String inputUsername, String inputPassword) {
        if (inputUsername == null || inputPassword == null) {
            return false;
        }
        
        return inputUsername.equals(expectedUsername) && inputPassword.equals(expectedPassword);
    }
}