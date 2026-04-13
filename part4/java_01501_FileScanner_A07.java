import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_01501_FileScanner_A07 {

    private final SecurityManager securityManager;

    public java_01501_FileScanner_A07() {
        this.securityManager = System.getSecurityManager();
    }

    public void scan(String directoryPath) {
        File directory = new File(directoryPath);

        if (securityManager != null && securityManager.checkPath(directory.getAbsolutePath()) != SecurityManager.OK) {
            System.out.println("Access denied: " + directoryPath);
            return;
        }

        try (Scanner scanner = new Scanner(directory)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + directoryPath);
        }
    }

    public static void main(String[] args) {
        VanillaFileScanner scanner = new VanillaFileScanner();
        scanner.scan("./path/to/directory");
    }
}