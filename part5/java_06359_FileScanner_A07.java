import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_06359_FileScanner_A07 {

    // A method to check for auth failure in a file
    public void checkAuthFailure(String filePath) {
        File file = new File(filePath);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("auth failure")) {
                    System.out.println("An auth failure has occurred in the file: " + filePath);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        }
    }
}