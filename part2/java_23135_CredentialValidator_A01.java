import java.util.Base64;

public class java_23135_CredentialValidator_A01 {
    private String userName;
    private String password;

    public java_23135_CredentialValidator_A01(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public boolean validate() {
        // This is a simple example of a credential validator. In a real-world scenario,
        // this method should use a secure method to hash and compare the passwords,
        // and not store passwords in plain text.

        // For the sake of simplicity, this example uses a static username and password.
        // In a real-world scenario, you should use a method to store and retrieve these values.
        if (userName.equals("admin") && password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("admin", "password");
        if (validator.validate()) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}