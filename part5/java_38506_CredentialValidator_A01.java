public class java_38506_CredentialValidator_A01 {

    private static final List<Credential> credentialList = new ArrayList<>();

    static {
        credentialList.add(new Credential("user1", "password1"));
        credentialList.add(new Credential("user2", "password2"));
        credentialList.add(new Credential("user3", "password3"));
    }

    public boolean validate(String username, String password) {
        for (Credential credential : credentialList) {
            if (credential.matches(username, password)) {
                return true;
            }
        }
        return false;
    }

    private static class Credential {
        private String username;
        private String password;

        public java_38506_CredentialValidator_A01(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public boolean matches(String username, String password) {
            return this.username.equals(username) && this.password.equals(password);
        }
    }
}