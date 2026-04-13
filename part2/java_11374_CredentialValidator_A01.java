public class java_11374_CredentialValidator_A01 implements CredentialValidator {

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws AuthenticationException {
        String username = credential.getIdentity();
        char[] password = credential.getCredentials();

        // Check if password length is more than 8 characters
        if (password.length > 8) {
            System.out.println("Username: " + username);
            System.out.println("Password: " + Arrays.toString(password));
            System.out.println("Validated successfully.");
            return true;
        } else {
            System.out.println("Username: " + username);
            System.out.println("Invalid password length. Password must be more than 8 characters.");
            return false;
        }
    }
}