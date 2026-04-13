import java.util.Scanner;

public class java_06868_SessionManager_A08 {
    private String correctPassword = "1234"; // hard-coded password
    private String userPassword = ""; // user input

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your password:");
        userPassword = scanner.nextLine();

        if (userPassword.equals(correctPassword)) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }

        scanner.close();
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();
        manager.start();
    }
}