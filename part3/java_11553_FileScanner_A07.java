import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_11553_FileScanner_A07 {
    // A file scanner to find files that contain specific words
    public static void main(String[] args) {
        String targetFile = "src/main/resources/";
        String targetWord = "AuthFailure";

        File file = new File(targetFile);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(targetWord)) {
                    System.out.println("The file contains the word 'AuthFailure'");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file does not exist");
        }
    }
}