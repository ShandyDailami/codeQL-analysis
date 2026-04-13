import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_25399_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("path/to/file");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains("authFailure")) {
                System.out.println("AuthFailure detected in line: " + line);
            }
        }

        scanner.close();
    }
}