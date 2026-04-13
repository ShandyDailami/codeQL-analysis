import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_04011_FileScanner_A07 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("path/to/file.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains("A07_AuthFailure")) {
                System.out.println("Authentication failure detected in: " + file.getAbsolutePath());
            }
        }

        scanner.close();
    }
}