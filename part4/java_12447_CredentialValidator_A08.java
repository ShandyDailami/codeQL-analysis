public class java_12447_CredentialValidator_A08 {

    // predefined users
    private static final User USER_A = new User("userA", "passwordA");
    private static final User USER_B = new User("userB", "passwordB");
    private static final User USER_C = new User("userC", "passwordC");

    // list of users
    private List<User> users = Arrays.asList(USER_A, USER_B, USER_C);

    public boolean validate(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    // User class
    public class User {
        private String username;
        private String password;

        public java_12447_CredentialValidator_A08(String username, String password) {
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