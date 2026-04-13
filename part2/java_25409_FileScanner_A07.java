import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_25409_FileScanner_A07 {
    public static void main(String[] args) {
        File file = new File("authfailure.txt");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("A07_AuthFailure")) {
                    System.out.println("AuthFailure detected in line: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getName());
        }
    }
}