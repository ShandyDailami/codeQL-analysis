import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_36688_FileScanner_A08 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // Replace with your directory path
        String integrityFailureFilePath = "/path/to/file"; // Replace with your integrity failure file path

        SecurityChecker checker = new SecurityChecker();
        checker.checkDirectoryIntegrity(directoryPath, integrityFailureFilePath);
    }

    public void checkDirectoryIntegrity(String directoryPath, String integrityFailureFilePath) {
        File directory = new File(directoryPath);
        File integrityFailureFile = new File(integrityFailureFilePath);

        if (!directory.exists()) {
            System.out.println("Directory not found!");
            return;
        }

        if (!integrityFailureFile.exists()) {
            System.out.println("Integrity failure file not found!");
            return;
        }

        try (Scanner fileScanner = new Scanner(integrityFailureFile)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();

                if (line.contains("INTEGRITY_FAILURE")) {
                    System.out.println("Security violation detected: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file: " + integrityFailureFilePath);
        }
    }
}