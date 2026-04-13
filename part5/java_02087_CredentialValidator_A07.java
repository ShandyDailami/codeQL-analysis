public class java_02087_CredentialValidator_A07 implements CredentialValidator {

    private String[][] credentialEntries = {
        {"alice", "hello"},
        {"bob", "world"},
        {"charlie", "abc123"}
    };

    @Override
    public boolean validate(String username, String password) throws AuthFailureException {
        for (int i = 0; i < credentialEntries.length; i++) {
            if (credentialEntries[i][0].equals(username) && credentialEntries[i][1].equals(password)) {
                return true;
            }
        }
        throw new AuthFailureException("Invalid credentials");
    }
}