public class java_20159_CredentialValidator_A08 {
    // UserCredentials is a simple data type that holds a username and password
    private UserCredentials userCredentials;

    public java_20159_CredentialValidator_A08() {
        userCredentials = new UserCredentials();
    }

    // method to set the username and password
    public void setUserCredentials(String username, String password) {
        userCredentials.setUsername(username);
        userCredentials.setPassword(password);
    }

    // method to validate the username and password
    public boolean validate() {
        // Here, I'm simulating a login operation. If the username and password match the expected values, it returns true. Otherwise, it returns false.
        if (userCredentials.getUsername().equals("admin") && userCredentials.getPassword().equals("password")) {
            return true;
        } else {
            return false;
        }
    }
}

public class UserCredentials {
    private String username;
    private String password;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
}

public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Setting the username and password
        validator.setUserCredentials("admin", "password");

        // Validating the username and password
        if (validator.validate()) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }
}