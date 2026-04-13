public class java_19681_CredentialValidator_A08 implements CredentialValidator {

    // List of valid users
    private List<User> validUsers = new ArrayList<>();

    public java_19681_CredentialValidator_A08() {
        validUsers.add(new User("username", "password"));
    }

    @Override
    public boolean validate(Credential c) throws IntegrityFailure {
        for (User user : validUsers) {
            if (user.getUsername().equals(c.getUsername()) && user.getPassword().equals(c.getPassword())) {
                return true;
            }
        }
        return false;
    }

    private class User {
        private String username;
        private String password;

        public java_19681_CredentialValidator_A08(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }
}