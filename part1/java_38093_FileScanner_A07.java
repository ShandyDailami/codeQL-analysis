import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_38093_FileScanner_A07 {
    public static void main(String[] args) {
        try {
            File file = new File("path/to/your/file.txt"); // replace with your file path
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // process the line, possibly checking for authentication failures
                // for now, we just print the line
                System.out.println(line);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}