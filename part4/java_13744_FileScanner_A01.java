import java.io.File;
import java.util.Scanner;

public class java_13744_FileScanner_A01 {

    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory:");
        String directory = scanner.nextLine();
        System.out.println("Enter file extension:");
        String extension = scanner.nextLine();

        File folder = new File(directory);
        File[] listOfFiles = folder.listFiles((dir, name) -> name.endsWith(extension));

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                System.out.println("Enter password to access " + file.getName());
                String inputPassword = scanner.nextLine();

                if (inputPassword.equals(PASSWORD)) {
                    System.out.println("Access granted to " + file.getName());
                    // Add access logic here if needed
                } else {
                    System.out.println("Access denied to " + file.getName());
                }
            }
        } else {
            System.out.println("No files found in the directory!");
        }

        scanner.close();
    }
}