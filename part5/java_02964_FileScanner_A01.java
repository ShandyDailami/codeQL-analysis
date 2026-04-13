import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_02964_FileScanner_A01 {
    private File file;

    public java_02964_FileScanner_A01(String filePath) throws FileNotFoundException {
        this.file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException("File not found at path: " + filePath);
        }
    }

    public void scan() {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Perform security-sensitive operations here
                // For instance, we're just printing the line for demonstration purposes
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            SecurityAwareFileScanner scanner = new SecurityAwareFileScanner("path_to_file");
            scanner.scan();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}