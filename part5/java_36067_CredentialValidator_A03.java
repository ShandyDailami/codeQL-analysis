import java.util.Scanner;

public class java_36067_CredentialValidator_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your username:");
        String username = scanner.nextLine();

        System.out.println("Please enter your password:");
        String password = scanner.nextLine();

        validate(username, password);
    }

    public static void validate(String username, String password) {
        if (username == null || username.isEmpty()) {
            System.out.println("Username cannot be null or empty");
            return;
        }

        if (password == null || password.isEmpty()) {
            System.out.println("Password cannot be null or empty");
            return;
       
        }

        System.out.println("Username and password are valid!");
    }
}