public class java_32470_CredentialValidator_A03 {
    // The actual username and password
    private String username = "admin";
    private String password = "password";

    // A method to validate the username and password
    public boolean validate(String enteredUsername, String enteredPassword) {
        if (enteredUsername != null && enteredUsername.equals(username)) {
            if (enteredPassword != null && enteredPassword.equals(password)) {
                return true;
            }
        }
        return false;
    }
}