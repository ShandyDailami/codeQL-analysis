public class java_04063_CredentialValidator_A01 {
    private String username;
    private String password;

    public java_04063_CredentialValidator_A01(String username, String password) {
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

public class CredentialValidator {
    public boolean authenticate(User user, String enteredUsername, String enteredPassword) {
        if (user.getUsername().equals(enteredUsername) && user.getPassword().equals(enteredPassword)) {
            return true;
        } else {
            return false;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        User user = new User("admin", "password");
        CredentialValidator validator = new CredentialValidator();
        
        if (validator.authenticate(user, "admin", "password")) {
            System.out.println("Authentication successful!");
        } else {
            System.out.println("Authentication failed!");
        }
    }
}