public class java_31529_CredentialValidator_A03 implements CredentialValidator {

    private static final String SUBSTRING = "admin"; // The substring to check for

    @Override
    public boolean validate(Credential credential) {
        String username = credential.getUsername();

        // Check if the username contains the specific substring
        if (username.contains(SUBSTRING)) {
            System.out.println("Invalid username: contains '" + SUBSTRING + "'");
            return false;
        }

        System.out.println("Valid username: '" + username + "'");
        return true;
    }
}