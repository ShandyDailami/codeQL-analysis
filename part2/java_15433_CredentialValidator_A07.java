public class java_15433_CredentialValidator_A07 {
    private String username;
    private String password;

    public java_15433_CredentialValidator_A07(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean validate() {
        // This is a placeholder for a more complex and security-sensitive operation
        // You should replace this with your actual logic for validating the credential
        if (username.equals("admin") && password.equals("password")) {
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
            System.out.println("Credentials are valid");
        } else {
            System.out.println("Credentials are not valid");
        }
    }
}