import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_11930_FileScanner_A08 {
    public static void main(String[] args) {
        try {
            File file = new File("path/to/file.txt"); // Replace with your file path
            Scanner scanner = new Scanner(file);

            // Read and print file content
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

            // Close scanner
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}