import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_32985_FileScanner_A07 {
    private static final String DIRECTORY_PATH = "path_to_directory";

    public static void main(String[] args) {
        File directory = new File(DIRECTORY_PATH);

        if (!directory.exists()) {
            System.out.println("Directory does not exist!");
            return;
        }

        if (!directory.isDirectory()) {
            System.out.println("Input is not a directory!");
            return;
        }

        try (Scanner scanner = new Scanner(directory)) {
            while (scanner.hasNextLine()) {
                String fileName = scanner.nextLine();
                File file = new File(fileName);

                if (file.isFile()) {
                    // Authentication failure code here
                    System.out.println("Authentication failure detected in file: " + fileName);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}