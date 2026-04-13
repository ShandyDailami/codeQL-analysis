// Start of code
public class java_13661_CredentialValidator_A01 {

    // This method validates if the username is valid
    public boolean validateUsername(String username) {
        // Here we just return true if the username is not null and not empty
        return (username != null && !username.isEmpty());
    }

    // This method validates if the password is valid
    public boolean validatePassword(String password) {
        // Here we just return true if the password is not null and not empty
        return (password != null && !password.isEmpty());
    }

    // This method combines the validation of the username and password
    public boolean validateCredentials(String username, String password) {
        return validateUsername(username) && validatePassword(password);
    }
}
// End of code