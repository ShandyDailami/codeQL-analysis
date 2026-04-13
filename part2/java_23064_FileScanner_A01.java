import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_23064_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";
        String fileExtension = ".txt";

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter your username:");
            String username = scanner.nextLine();

            System.out.println("Enter your password:");
            String password = scanner.nextLine(); // Here we assume the password is entered directly from the console.

            File directory = new File(directoryPath);
            File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

            if (txtFiles != null) {
                for (File file : txtFiles) {
                    try (Scanner fileScanner = new Scanner(file)) {
                        while (fileScanner.hasNextLine()) {
                            String line = fileScanner.nextLine();

                            if (line.contains(username) && line.contains(password)) {
                                System.out.println("Found suspicious activity in: " + file.getPath());
                            }
                        }
                    }
                }
            } else {
                System.out.println("No .txt files found in the specified directory.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}