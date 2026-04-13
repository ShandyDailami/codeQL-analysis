public class java_31796_CredentialValidator_A07 implements CredentialValidator {

    // This is a hardcoded password, you should use a real password storage for production
    private String hardcodedPassword = "password";

    @Override
    public boolean validate(Credential credential) {
        String presentedPassword = credential.getPassword();
        
        // If the presented password is null, it means no password was presented
        if (presentedPassword == null) {
            return false;
        }

        // Compare the presented password with the hardcoded password
        return presentedPassword.equals(hardcodedPassword);
    }

}