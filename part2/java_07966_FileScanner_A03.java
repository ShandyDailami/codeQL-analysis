import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_07966_FileScanner_A03 {
    private final String filePath;

    public java_07966_FileScanner_A03(String filePath) {
        this.filePath = filePath;
    }

    public void scan() {
        File file = new File(filePath);
        if (file.exists()) {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    // The line below is a security-sensitive operation related to injection.
                    // This operation could be anything from parameter injection to SQL injection.
                    // For simplicity, this example only prints the line, but in a real-world scenario,
                    // you would replace this with a more secure operation.
                    System.out.println(line);
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + filePath);
            }
        } else {
            System.out.println("File not found: " + filePath);
        }
    }
}