import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.security.AccessControlException;
import java.security.AccessDeniedException;

public class java_33931_FileScanner_A08 {
    private static final String DIRECTORY = "path_to_directory"; // Replace with your directory

    public static void main(String[] args) {
        File directory = new File(DIRECTORY);

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter directory path:");
            String path = scanner.nextLine();

            if (directory.canRead(path)) {
                File file = new File(path);
                Scanner fileScanner = new Scanner(file);

                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    System.out.println(line);
                }
                fileScanner.close();
            } else {
                throw new AccessDeniedException("Access denied");
            }
        } catch (AccessControlException | FileNotFoundException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}