import java.io.File;
import java.util.Scanner;

public class java_08072_FileScanner_A03 {
    private File file;

    public java_08072_FileScanner_A03(String fileName) {
        this.file = new File(fileName);
    }

    public void scan(String fileName) {
        try {
            Scanner scanner = new Scanner(this.file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Here we should be careful about our security operations to prevent injection attacks.
                // In this case, we're just echoing back the line to be safe.
                System.out.println(line);
            }
            scanner.close();
        } catch (Exception e) {
            // Handle exception appropriately for security sensitive operations.
            System.out.println("Error scanning file: " + e.getMessage());
        }
    }
}