import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_31536_FileScanner_A01 {

    private static final String SECRET_FOLDER = "/path/to/secret/folder";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();

        if (validatePassword(password)) {
            scanFilesInFolder(SECRET_FOLDER);
        } else {
            System.out.println("Access denied!");
        }

        scanner.close();
    }

    private static boolean validatePassword(String password) {
        // In real application, you would validate the password against a hash or other secure method
        // For this example, we'll just return true or false based on whether the password is "password"
        return password.equals("password");
    }

    private static void scanFilesInFolder(String folderPath) {
        File folder = new File(folderPath);
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    // You can use a try-with-resources statement to automatically close the scanner when you're done with it
                    try (Scanner fileScanner = new Scanner(file)) {
                        while (fileScanner.hasNextLine()) {
                            String line = fileScanner.nextLine();
                            System.out.println("Line in file: " + line);
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}