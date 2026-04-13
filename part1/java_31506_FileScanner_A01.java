import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_31506_FileScanner_A01 {
    public static void main(String[] args) {
        try {
            File file = new File("src/main/resources/access.log");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Assume that the log file only contains valid access events,
                // and that the log file is safe to read due to security measures
                if (line.contains("SUCCESSFUL_LOGIN")) {
                    System.out.println("Successful login detected in " + line);
                } else if (line.contains("FAILED_LOGIN")) {
                    System.out.println("Failed login detected in " + line);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: Unable to access the log file. " + e.getMessage());
        }
    }
}