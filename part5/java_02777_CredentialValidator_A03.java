public class java_02777_CredentialValidator_A03 implements javax.security.auth.login.CredentialValidator {

    private static final String[][] credentialData = {
        {"user1", "password1"},
        {"user2", "password2"},
        {"user3", "password3"},
    };

    @Override
    public String getCaller() {
        return "CredentialValidator";
    }

    @Override
    public String getPassword(String userName) {
        return userName;
    }

    @Override
    public boolean validate(String caller, String password) {
        for (String[] credential : credentialData) {
            if (credential[0].equals(caller) && credential[1].equals(password)) {
                return true;
            }
        }
        return false;
    }
}