public class java_32315_CredentialValidator_A01 implements CredentialValidator {

    // Predefined password
    private String password = "123456";

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws InvalidCredentialException {
        // Get the entered password
        String enteredPassword = credential.getPasswordAsString();

        // Check if entered password is the same as predefined password
        if (enteredPassword.equals(password)) {
            return true;
        } else {
            throw new InvalidCredentialException("Incorrect password");
        }
    }
}