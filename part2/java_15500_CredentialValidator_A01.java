public class java_15500_CredentialValidator_A01 {

    private String username;
    private String password;

    public java_15500_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean validate() {
        // In a real system, you would use a secure way to compare passwords
        // This is a simplistic example
        return this.username.equals("admin") && this.password.equals("password");
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