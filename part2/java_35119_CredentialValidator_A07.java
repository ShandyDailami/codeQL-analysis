public class java_35119_CredentialValidator_A07 implements CredentialValidator {

    // This is a hard-coded password.
    private String hardCodedPassword = "password";

    @Override
    public boolean validate(String username, String password) {
        // If the username is not null and the password is not null and the password matches the hard-coded password,
        // return true. Otherwise, return false.
        return (username != null && password != null && password.equals(hardCodedPassword));
    }
}