public class java_40261_CredentialValidator_A08 {

    // User database (stub)
    private static User[] users = {
        new User("alice", "pa$$word123"),
        new User("bob", "strongerpassword")
    };

    public static class User {
        public String username;
        public String password;

        public java_40261_CredentialValidator_A08(String username, String password) {
            this.username = username;
            this.password = password;
        }
    }

    public static void main(String[] args) {
        validateCredentials("alice", "pa$$word123");
    }

    public static boolean validateCredentials(String username, String password) {
        // Iterate over users to find a match
        for (User user : users) {
            if (user.username.equals(username) && user.password.equals(password)) {
                System.out.println("Credentials are valid!");
                return true;
            }
        }
        
        System.out.println("Credentials are invalid!");
        return false;
    }
}