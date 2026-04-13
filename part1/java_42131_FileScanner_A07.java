import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_42131_FileScanner_A07 {

    public static void main(String[] args) {
        File file = new File("src/main/resources/A07_AuthFailure.txt");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if (line.trim().startsWith("A07_AuthFailure")) {
                    System.out.println("AuthFailure found: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}