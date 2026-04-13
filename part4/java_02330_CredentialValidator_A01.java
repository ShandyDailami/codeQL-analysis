public class java_02330_CredentialValidator_A01 {

    private String username;
    private String password;

    public java_02330_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean validate() {
        // This is a placeholder for a real-world implementation
        // that would verify the username and password against a database or other
        // security system. This is a simple demonstration of a CredentialValidator.
        if (this.username.equals("admin") && this.password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }
}

public class Main {

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("admin", "password");
        if (validator.validate()) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }
}