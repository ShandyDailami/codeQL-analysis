public class java_36257_CredentialValidator_A03 {

    // Simple user store for demonstration
    private static User user = new User("user", "password");

    // Simple password store for demonstration
    private static Password password = new Password("storedPassword");

    public static boolean validate(String username, String password) {
        return user.getUsername().equals(username) &&
                password.getPassword().equals(hashPassword(password));
    }

    // We'll use a simple hash function for demonstration
    private static String hashPassword(String password) {
        return String.valueOf((password.hashCode()));
    }

    public static void main(String[] args) {
        String username = "user";
        String password = "storedPassword";
        boolean isValid = CredentialValidator.validate(username, password);
        if (isValid) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}

class User {
    private String username;
    private String password;

    public java_36257_CredentialValidator_A03(String username, String password) {
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

class Password {
    private String password;

    public java_36257_CredentialValidator_A03(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}