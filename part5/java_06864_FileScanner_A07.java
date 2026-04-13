import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_06864_FileScanner_A07 {
    public static void main(String[] args) {
        try {
            File file = new File("path/to/your/file.txt"); // replace with your file path
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.startsWith("0")) {
                    System.out.println(line);
                }
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}