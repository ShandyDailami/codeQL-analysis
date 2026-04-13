public class java_25906_CredentialValidator_A03 {

    private String[][] credentialData = {
        {"user1", "password1"},
        {"user2", "password2"},
        {"user3", "password3"}
    };

    public boolean validateCredentials(String username, String password) {
        for (String[] credential : credentialData) {
            if (credential[0].equals(username) && credential[1].equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        boolean isValid = validator.validateCredentials("user1", "password1");
        System.out.println("Is valid: " + isValid);
    }
}