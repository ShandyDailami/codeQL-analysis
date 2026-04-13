import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_06813_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("path/to/your/file");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains("authFailure")) { // Security-sensitive operation
                System.out.println("AuthFailure detected in line: " + line);
            }
        }

        scanner.close();
    }
}