import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_05670_FileScanner_A07 {
    private static final String AUTH_FAILURE = "A07_AuthFailure";
    private static final String SECURITY_HINT = "Please use a secure connection";

    public static void main(String[] args) {
        File file = new File("src/main/resources/secureFile.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(AUTH_FAILURE)) {
                    System.out.println(SECURITY_HINT);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}