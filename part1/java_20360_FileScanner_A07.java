import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_20360_FileScanner_A07 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("path_to_your_file");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains("A07_AuthFailure")) {
                System.out.println("Authentication failure detected in line: " + line);
            }
        }
        scanner.close();
    }
}