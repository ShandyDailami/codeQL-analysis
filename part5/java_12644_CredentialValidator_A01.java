public class java_12644_CredentialValidator_A01 {
    private String username;
    private String password;

    public java_12644_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean validate() {
        // Hardcoded credentials
        if (this.username.equals("admin") && this.password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Username and password hardcoded for the sake of simplicity
        CredentialValidator validator = new CredentialValidator("admin", "password");
        if (validator.validate()) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}