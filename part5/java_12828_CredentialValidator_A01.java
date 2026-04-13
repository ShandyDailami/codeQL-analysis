public class java_12828_CredentialValidator_A01 {

    private String username;
    private String password;

    public java_12828_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean isValid() {
        // For simplicity, we'll check if the username and password are not null or empty
        // In a real-world application, you should also check for password length,
        // complexity, and other security measures

        return (username != null && !username.isEmpty())
                && (password != null && !password.isEmpty());
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}

public class BrokenAccessControl {

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("user", "password");

        if (validator.isValid()) {
            System.out.println("Valid credentials: " + validator.getUsername() + ", " + validator.getPassword());
        } else {
            System.out.println("Invalid credentials");
        }
    }

}