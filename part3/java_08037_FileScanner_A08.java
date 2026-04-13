import java.io.*;
import java.util.Scanner;

public class java_08037_FileScanner_A08 {
    public static void main(String[] args) throws IOException {
        File file = new File("example.txt");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the password:");
        String password = scanner.nextLine();

        if (checkPassword(file, password)) {
            Scanner scannerFile = new Scanner(file);
            while (scannerFile.hasNextLine()) {
                System.out.println(scannerFile.nextLine());
            }
        } else {
            System.out.println("Access denied!");
        }

        scanner.close();
    }

    private static boolean checkPassword(File file, String password) {
        // This method would be responsible for checking the password
        // Here, we're just checking if the password is "password"
        return password.equals("password");
    }
}