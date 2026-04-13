import java.io.File;
import java.util.Scanner;

public class java_00423_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();
        System.out.print("Enter the file name: ");
        String fileName = scanner.nextLine();

        File directory = new File(directoryPath);
        File file = new File(directory, fileName);

        if (!file.exists()) {
            System.out.println("File does not exist.");
            return;
        }

        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                // This is where we would typically handle the line for security-sensitive operations
                // This is a placeholder and actual implementation would depend on the specifics of the application
                handleLine(line);
            }
        } catch (Exception e) {
            System.out.println("Error processing file: " + e.getMessage());
        }
    }

    private static void handleLine(String line) {
        // This is where we would handle the line for security-sensitive operations
        // This is a placeholder and actual implementation would depend on the specifics of the application
        System.out.println(line);
    }
}