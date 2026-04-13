import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_36921_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        String filename = "path_to_your_file.txt"; // replace with your file path
        File file = new File(filename);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains("A07_AuthFailure")) {
                System.out.println(line);
            }
        }

        scanner.close();
    }
}