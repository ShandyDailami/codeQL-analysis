import java.io.File;
import java.util.Scanner;

public class java_07412_FileScanner_A07 {

    private static final String username = "admin";
    private static final String password = "password";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username:");
        String inputUsername = scanner.next();
        System.out.println("Enter password:");
        String inputPassword = scanner.next();

        if (authenticate(inputUsername, inputPassword)) {
            scannerDirectory(new File("."));
        } else {
            System.out.println("Authentication failed, please try again.");
        }
        scanner.close();
    }

    private static boolean authenticate(String username, String password) {
        return username.equals(username) && password.equals(password);
    }

    private static void scannerDirectory(File file) {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            for (File f : listFiles) {
                scannerDirectory(f);
            }
        } else if (file.getName().endsWith(".txt")) {
            System.out.println(file.getAbsolutePath());
        }
    }
}