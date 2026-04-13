public class java_32824_CredentialValidator_A01 implements CredentialValidator {
    // Hardcoded list of valid users.
    private static final List<User> VALID_USERS = Arrays.asList(
            new User("user1", "password1", "Admin"),
            new User("user2", "password2", "User"),
            new User("user3", "password3", "Guest")
    );

    @Override
    public boolean validate(String username, String password) {
        for (User user : VALID_USERS) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CredentialValidatorImpl validator = new CredentialValidatorImpl();

        String username = "user1";
        String password = "password1";

        if (validator.validate(username, password)) {
            System.out.println("Access granted to user: " + username);
        } else {
            System.out.println("Access denied for user: " + username);
        }
    }
}

interface CredentialValidator {
    boolean validate(String username, String password);
}

class User {
    private String username;
    private String password;
    private String role;

    public java_32824_CredentialValidator_A01(String username, String password, String role) {
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