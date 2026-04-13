public class java_27600_CredentialValidator_A01 implements CredentialValidator {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws AuthenticationException {
        String name = credential.getIdentifier();
        char[] password = credential.getPassword();

        // Convert password to plain text for simplicity
        // In a real-world application, you should use a secure method to convert the password to plain text
        if(name.equals(USERNAME) && new String(password) .equals(PASSWORD)){
            return true;
        }
        return false;
    }
}