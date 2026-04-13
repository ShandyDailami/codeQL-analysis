public class java_34448_CredentialValidator_A01 {

    // A list of users, each with a username and password
    private List<User> users = Arrays.asList(
        new User("user1", "password1"),
        new User("user2", "password2"),
        new User("user3", "password3"));

    // A class to represent a user (with a username and password)
    public class User {
        private String username;
        private String password;

        public java_34448_CredentialValidator_A01(String username, String password) {
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

    // A method to validate a username and password
    public boolean validate(String username, String password) {
        // Iterate over the list of users
        for (User user : users) {
            // If the username and password match, return true
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        // If no match is found, return false
        return false;
    }
}