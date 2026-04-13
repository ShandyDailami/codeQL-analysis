public class java_01849_CredentialValidator_A08 {
    private String username;
    private String password;

    public java_01849_CredentialValidator_A08(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean validate() {
        // In a real application, you would likely compare the provided password with a hashed version of the stored password
        // This is a simplification for the sake of the example
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
            System.out.println("Access granted.");
        } else {
            System.out.println("Access denied.");
        }
    }
}