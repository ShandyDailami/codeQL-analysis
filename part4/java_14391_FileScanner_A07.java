import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_14391_FileScanner_A07 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("AuthFailure.log");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains("A07_AuthFailure")) {
                System.out.println("AuthFailure detected in log file: " + line);
            }
        }

        scanner.close();
    }
}