public class java_16815_CredentialValidator_A01 implements CredentialValidator {

    private List<User> validUsers;

    public java_16815_CredentialValidator_A01() {
        validUsers = new ArrayList<>();
        // Add some valid users for the example
        validUsers.add(new User("user1", "password1"));
        validUsers.add(new User("user2", "password2"));
        validUsers.add(new User("user3", "password3"));
    }

    @Override
    public boolean validate(String username, String password) {
        for (User user : validUsers) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    private class User {
        private String username;
        private String password;

        public java_16815_CredentialValidator_A01(String username, String password) {
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