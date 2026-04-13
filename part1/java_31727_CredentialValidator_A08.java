public class java_31727_CredentialValidator_A08 {

    private String[][] validCredentials = {
        {"user1", "password1"},
        {"user2", "password2"},
        {"user3", "password3"},
        {"user4", "password4"},
        {"user5", "password5"}
    };

    public boolean validate(String username, String password) {
        for (int i = 0; i < validCredentials.length; i++) {
            if (validCredentials[i][0].equals(username) && validCredentials[i][1].equals(password)) {
                return true;
            }
        }
        return false;
    }
}