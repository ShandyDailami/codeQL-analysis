import java.util.Scanner;

public class java_29763_CredentialValidator_A07 {
    private String username;
    private String password;

    public java_29763_CredentialValidator_A07() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your username:");
        this.username = scanner.next();

        System.out.println("Enter your password:");
        this.password = scanner.next();
   
        scanner.close();
    }

    public boolean validate() {
        // For simplicity, we'll just check if the username and password match
        if (this.username.equals("admin") && this.password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        if (validator.validate()) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}