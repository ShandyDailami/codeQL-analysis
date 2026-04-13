import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_19803_FileScanner_A08 {
    private static final String INTEGRITY_FAILURE = "A08_IntegrityFailure";

    public static void main(String[] args) {
        File file = new File("src/main/resources/integrityCheck.txt");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(INTEGRITY_FAILURE)) {
                    System.out.println("Integrity failure detected in: " + file.getPath());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getPath());
        }
    }
}