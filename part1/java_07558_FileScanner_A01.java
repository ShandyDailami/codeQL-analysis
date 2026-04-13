import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_07558_FileScanner_A01 {
    public static void main(String[] args) {
        File file = new File("path/to/your/file");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (isSecurityVulnerable(line)) {
                System.out.println("Security vulnerability detected in line: " + line);
            }
        }

        scanner.close();
    }

    private static boolean isSecurityVulnerable(String line) {
        // This is a simple example of a security vulnerability. 
        // In reality, you would need to use more complex logic to detect this.
        // This should only be used for educational purposes.
        return line.contains("unsafe") || line.contains("broken") || line.contains("insecure");
    }
}