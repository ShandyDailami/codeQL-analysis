import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_22892_FileScanner_A08 {

    private static final String DIRECTORY_PATH = "/path/to/directory";
    private static final String EXTENSION = ".txt";

    public static void main(String[] args) {
        File directory = new File(DIRECTORY_PATH);
        File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(EXTENSION));

        if (txtFiles != null) {
            for (File txtFile : txtFiles) {
                checkIntegrity(txtFile);
            }
        }
    }

    private static void checkIntegrity(File file) {
        if (file != null && file.exists() && file.isFile()) {
            try (Scanner scanner = new Scanner(file)) {
                boolean integrityIssueFound = false;
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (!isValidLine(line)) {
                        integrityIssueFound = true;
                        break;
                    }
                }
                if (integrityIssueFound) {
                    System.out.println("Integrity failure detected in file: " + file.getName());
                } else {
                    System.out.println("File: " + file.getName() + " has valid lines.");
                }
            } catch (FileNotFoundException e) {
                System.out.println("Error reading file: " + file.getName());
            }
        } else {
            System.out.println("Invalid file: " + file.getName());
        }
    }

    private static boolean isValidLine(String line) {
        // Implement your own logic to check the integrity of a line here.
        // For simplicity, we just return true if the line is not empty.
        return !line.trim().isEmpty();
    }
}