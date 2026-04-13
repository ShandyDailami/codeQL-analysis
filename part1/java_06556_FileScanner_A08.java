import java.io.File;
import java.util.Scanner;

public class java_06556_FileScanner_A08 {
    private static final String SECURITY_THREAT_PREFIX = "A08_IntegrityFailure: ";
    private static final String DIR_PATH = "C:/path/to/directory";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File(DIR_PATH))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.startsWith(SECURITY_THREAT_PREFIX)) {
                    System.out.println(SECURITY_THREAT_PREFIX + line.substring(SECURITY_THREAT_PREFIX.length()));
                }
           
                // Remove comment for real code
                // System.out.println("Line: " + line);
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}