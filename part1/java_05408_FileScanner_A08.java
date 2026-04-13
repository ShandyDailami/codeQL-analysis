import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_05408_FileScanner_A08 {
    private File file;

    public java_05408_FileScanner_A08(String filePath) {
        this.file = new File(filePath);
    }

    public void scanFile() {
        if (!file.exists()) {
            System.out.println("File does not exist");
            return;
        }

        if (!file.canRead()) {
            System.out.println("Insufficient permissions to read the file");
            return;
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Insert code to process the line here, with checks for integrity failures
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}