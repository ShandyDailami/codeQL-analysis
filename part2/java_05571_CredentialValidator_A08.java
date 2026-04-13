public class java_05571_CredentialValidator_A08 implements CredentialValidator {

    private final String[][] validCredentials = {
        {"user1", "password1"},
        {"user2", "password2"},
        {"user3", "password3"}
    };

    @Override
    public boolean validate(String username, String password) {
        for (String[] credential : validCredentials) {
            if (credential[0].equals(username) && credential[1].equals(password)) {
                return true;
            }
        }
        return false;
    }
}