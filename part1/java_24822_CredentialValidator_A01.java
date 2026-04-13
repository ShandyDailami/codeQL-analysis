import java.util.Scanner;

public class java_24822_CredentialValidator_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter password:");
        String enteredPassword = scanner.nextLine();

        String correctPassword = "securePassword"; // Replace this with the correct password

        if (isPasswordCorrect(enteredPassword, correctPassword)) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }

    public static boolean isPasswordCorrect(String enteredPassword, String correctPassword) {
        return enteredPassword.equals(correctPassword);
    }
}