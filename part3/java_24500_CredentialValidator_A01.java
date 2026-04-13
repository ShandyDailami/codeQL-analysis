public class java_24500_CredentialValidator_A01 {

    private String username;
    private String password;

    public java_24500_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean isValid() {
        // In a real-world scenario, you'd want to hash and salt the password for security reasons
        // And also compare the hashed password to a stored hashed password in your database
        if (this.username.equals("admin") && this.password.equals("password")) {
            return true;
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("admin", "password");
        if (validator.isValid()) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}