public class java_14406_CredentialValidator_A03 {

    private String userDatabase;

    public java_14406_CredentialValidator_A03(String userDatabase) {
        this.userDatabase = userDatabase;
    }

    public boolean validateCredentials(String userName, String password) {
        // Assume the userDatabase is a list of users and their passwords
        // If userName and password match a user in the database, return true
        // Otherwise, return false
        // This is a very simple example and does not cover all possible injection attacks
        // You would need to implement a secure way to compare the inputted password with the stored password
        // For example, use a hash function to compare the passwords

        for (User user : userDatabase.getUsers()) {
            if (user.getUsername().equals(userName) && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        UserDatabase userDatabase = new UserDatabase();
        userDatabase.addUser(new User("user1", "password1"));
        userDatabase.addUser(new User("user2", "password2"));
        CredentialValidator validator = new CredentialValidator(userDatabase);

        if (validator.validateCredentials("user1", "wrongpassword")) {
            System.out.println("Invalid password for user1");
        } else if (validator.validateCredentials("user2", "password2")) {
            System.out.println("Valid password for user2");
        } else {
            System.out.println("Invalid credentials");
        }
    }
}

class User {
    private String username;
    private String password;

    public java_14406_CredentialValidator_A03(String username, String password) {
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

class UserDatabase {
    private List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }
}