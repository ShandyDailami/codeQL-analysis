import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_29011_FileScanner_A07 {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("src/main/resources/A07_AuthFailure.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("authFailure")) {
                    System.out.println("Auth Failure detected: " + line);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}