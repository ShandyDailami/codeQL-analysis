import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_15310_FileScanner_A03 {

    public static void main(String[] args) {
        String directory = "/path/to/directory";
        String extension = ".txt";

        try {
            File file = new File(directory, "file" + extension);
            if (file.exists()) {
                removeInjectionAttacks(file);
            } else {
                System.out.println("File not found in directory!");
            }
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

    private static void removeInjectionAttacks(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            // Removing possible injection attacks here
            line = line.replace("'", "''"); // Replace single quotes with two single quotes
            line = line.replace(";", ""); // Remove semicolons
            line = line.replace("DROP", ""); // Remove DROP keyword
            // Continue with the rest of the code
        }
        // Close scanner
        scanner.close();
    }
}