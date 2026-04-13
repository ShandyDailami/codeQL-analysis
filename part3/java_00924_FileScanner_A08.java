import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_00924_FileScanner_A08 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("/path/to/your/file.txt"));  // Use a real file path.
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);  // Print each line.
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}