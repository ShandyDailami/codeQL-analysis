import java.util.Scanner;

public class java_36017_CredentialValidator_A03 {

    // User database, this is not real, in a real system it would come from a database.
    private static String[][] users = {
        {"user1", "password1"},
        {"user2", "password2"},
        {"user3", "password3"},
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your username:");
        String username = scanner.nextLine();

        System.out.println("Enter your password:");
        String password = scanner.nextLine();

        if (validate(username, password)) {
            System.out.println("You are authenticated!");
        } else {
            System.out.println("Invalid username or password.");
        }

        scanner.close();
    }

    private static boolean validate(String username, String password) {
        for (String[] user : users) {
            if (user[0].equals(username) && user[1].equals(password)) {
                return true;
            }
        }
        return false;
    }
}