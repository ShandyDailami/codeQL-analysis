import java.io.File;
import java.util.Scanner;

public class java_20687_FileScanner_A03 {
    private static final String DIRECTORY = "C:\\Users\\YourUserName\\Downloads";

    public static void main(String[] args) {
        File directory = new File(DIRECTORY);
        File[] listOfFiles = directory.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        // This is a security-sensitive operation, consider using a library like OWASP Java Encoder for improved prevention of injection attacks.
                        line = line.replaceAll("(?i)your_injection_here", "REDACTED");
                        // Continue with your logic to handle the file.
                    }
                    scanner.close();
                }
            }
        }
    }
}