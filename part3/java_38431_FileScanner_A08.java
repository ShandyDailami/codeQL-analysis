import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_38431_FileScanner_A08 {
    private File file;

    public java_38431_FileScanner_A08(String filePath) throws FileNotFoundException {
        file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException("File not found: " + filePath);
        }
    }

    public void scan() {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Handle the line here
                handleLine(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getPath());
        }
    }

    private void handleLine(String line) {
        // Empty for now as the specifics of handling a line depend on the specifics of your project
    }

    public static void main(String[] args) {
        try {
            FileScanner scanner = new FileScanner("path/to/file");
            scanner.scan();
        } catch (FileNotFoundException e) {
            System.out.println("Error scanning file: " + e.getMessage());
        }
    }
}