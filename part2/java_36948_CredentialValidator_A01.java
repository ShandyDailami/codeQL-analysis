public class java_36948_CredentialValidator_A01 {

    // In real-world scenarios, you'd usually use a more secure way to
    // store the real credentials in a more secure way
    private final String expectedUsername = "admin";
    private final String expectedPassword = "password";

    public boolean validate(String username, String password) {
        if (username.equals(expectedUsername) && password.equals(expectedPassword)) {
            return true;
        } else {
            return false;
        }
    }

}