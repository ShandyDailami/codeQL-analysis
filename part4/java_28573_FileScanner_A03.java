import java.io.File;
import java.util.Scanner;

public class java_28573_FileScanner_A03 {
    public static void main(String[] args) {
        // Create a scanner for command line arguments
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        // Scan the directory
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        // Get all .txt files
        File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));
        if (txtFiles == null) {
            System.out.println("No .txt files found in directory");
            return;
        }

        // Print out the contents of each .txt file
        for (File txtFile : txtFiles) {
            try (Scanner fileScanner = new Scanner(txtFile)) {
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    System.out.println(line);
                }
            } catch (Exception e) {
                System.out.println("Error reading file: " + txtFile.getName());
            }
        }
    }
}