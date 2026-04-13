import java.util.Scanner;

public class java_11156_CredentialValidator_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your password:");
        String password = scanner.nextLine();

        if (validatePassword(password)) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }

    public static boolean validatePassword(String password) {
        // Hard-coded passwords
        String hardCodedPassword = "password";
        return password.equals(hardCodedPassword);
    }
}