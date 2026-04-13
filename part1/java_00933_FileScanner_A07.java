import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_00933_FileScanner_A07 {

    public static void main(String[] args) throws FileNotFoundException {
        String filePath = "/path/to/file.txt"; // Update this with your file path
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.trim().equals("A07_AuthFailure")) {
                System.out.println("AuthFailure detected in line: " + line);
            }
        }

        scanner.close();
    }
}