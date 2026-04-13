import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_03382_FileScanner_A07 {
    private static final String DIR_PATH = "/path/to/directory";
    private static final String EXCLUDED_FILES = "excluded_files.txt";

    public static void main(String[] args) {
        File dir = new File(DIR_PATH);
        File excludedFiles = new File(EXCLUDED_FILES);

        try (Scanner scanner = new Scanner(excludedFiles)) {
            while (scanner.hasNextLine()) {
                String excludedFileName = scanner.nextLine();
                File excludedFile = new File(dir, excludedFileName);

                if (excludedFile.exists()) {
                    System.out.println("Security failure detected in file: " + excludedFile.getPath());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Excluded files file not found: " + e.getMessage());
        }
    }
}