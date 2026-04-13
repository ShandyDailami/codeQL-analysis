import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_25081_FileScanner_A07 {

    public static void main(String[] args) {
        File file = new File("src/main/resources/authfailure.txt");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.matches(".*(A07_AuthFailure).*")) {
                    System.out.println("Detected 'A07_AuthFailure' in line: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}