public class java_18901_CredentialValidator_A01 implements CredentialValidator {

    private List<User> userList;

    public java_18901_CredentialValidator_A01() {
        userList = new ArrayList<>();
        userList.add(new User("user1", "password1", "ROLE_ADMIN"));
        userList.add(new User("user2", "password2", "ROLE_USER"));
    }

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws CredentialValidationException {
        String username = credential.getIdentifier();
        String password = credential.getCredentials();

        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    private class User {
        private String username;
        private String password;
        private String role;

        public java_18901_CredentialValidator_A01(String username, String password, String role) {
            this.username = username;
            this.password = password;
            this.role = role;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        public String getRole() {
            return role;
        }
    }
}