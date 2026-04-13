import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_26664_FileScanner_A07 {
    private static final String AUTH_FAILURE_WORD = "AuthFailure";

    public static void main(String[] args) {
        File file = new File("target/file.txt"); // replace with your file path
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(AUTH_FAILURE_WORD)) {
                    System.out.println("The file contains the word 'AuthFailure'");
                    return;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
        System.out.println("The file does not contain the word 'AuthFailure'");
    }
}