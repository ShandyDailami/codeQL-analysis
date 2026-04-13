import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_27421_FileScanner_A08 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        System.out.println("Scanning directory: " + directoryPath);

        try (Scanner scanner = new Scanner(directory)) {
            while (scanner.hasNext()) {
                String fileName = scanner.next();
                File file = new File(directoryPath + "/" + fileName);

                if (!file.exists()) {
                    System.out.println("File does not exist: " + fileName);
                    continue;
                }

                try {
                    // Check file for integrity
                    if (checkFileIntegrity(file)) {
                        System.out.println("File " + fileName + " has integrity issues");
                    } else {
                        System.out.println("File " + fileName + " has no integrity issues");
                    }
                } catch (Exception e) {
                    System.out.println("An error occurred while checking file integrity: " + e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Directory does not exist: " + e.getMessage());
        }
    }

    private static boolean checkFileIntegrity(File file) {
        // Add your file integrity check logic here
        // For now, we will just return false to simulate an integrity failure
        return false;
    }
}