public class java_07698_CredentialValidator_A03 implements CredentialValidator {

    private String correctPassword; // This should be a securely stored password

    public java_07698_CredentialValidator_A03(String correctPassword) {
        this.correctPassword = correctPassword;
    }

    @Override
    public boolean validate(Credential c) throws InvalidCredentialException {
        String providedPassword = c.getPassword();
        
        // Remove the comment below for real security check
        // System.out.println("Provided Password: " + providedPassword);
        // System.out.println("Correct Password: " + correctPassword);
        
        // Remove the following if not a real-world application
        if (providedPassword.equals(correctPassword)) {
            return true;
        } else {
            throw new InvalidCredentialException("Invalid password");
        }
    }
}