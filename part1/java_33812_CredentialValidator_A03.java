// a. Creating a CredentialValidator class java_33812_CredentialValidator_A03 class CredentialValidator {

    // b. The CredentialValidator class will have a method to validate a user's credentials
    public boolean validate(User user) {

        // c. We will use a simple string comparison for now
        // d. Here's a very basic way to do this, using the User's credentials to match with our predefined credentials
        if (user.getUsername().equals("admin") && user.getPassword().equals("password")) {
            return true;
        } else {
            return false;
        }
    }
}

// a. Creating a User class
public class User {

    // c. The User class will have a constructor that initializes the username and password
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // d. The User class will have fields for the username and password
    private String username;
    private String password;

    // a. Getters for the username and password fields
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

// a. Main class
public class Main {

    // e. The main method
    public static void main(String[] args) {

        // f. Here's how you might use the CredentialValidator to validate a user's credentials
        CredentialValidator validator = new CredentialValidator();

        User user = new User("admin", "password");

        if (validator.validate(user)) {
            System.out.println("Credentials validated successfully.");
        } else {
            System.out.println("Credentials invalid.");
        }
    }
}