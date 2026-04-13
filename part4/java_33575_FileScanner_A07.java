import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_33575_FileScanner_A07 {
    private static final String SECURITY_FAILURE_MESSAGE = "Security failure detected!";

    public static void main(String[] args) {
        File directory = new File("path_to_directory");
        String extension = "extension_to_scan";

        try (Scanner scanner = new Scanner(directory)) {
            while (scanner.hasNextLine()) {
                String filePath = scanner.nextLine();
                File file = new File(filePath);

                if (!file.canRead() || !file.getName().endsWith(extension)) {
                    throw new SecurityException(SECURITY_FAILURE_MESSAGE);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Directory not found: " + e.getMessage());
        } catch (SecurityException e) {
            System.out.println(e.getMessage());
        }
    }
}