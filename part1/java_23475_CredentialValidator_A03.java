public class java_23475_CredentialValidator_A03 {
    private String[][] knownCredentials = {
        {"username1", "password1"},
        {"username2", "password2"},
        {"username3", "password3"}
    };

    public boolean validate(String username, String password) {
        for (int i = 0; i < knownCredentials.length; i++) {
            if (knownCredentials[i][0].equals(username) && knownCredentials[i][1].equals(password)) {
                return true;
            }
        }
        return false;
    }
}