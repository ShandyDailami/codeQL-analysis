import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_08812_FileScanner_A07 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("path/to/your/file.txt")); // replace "path/to/your/file.txt" with the actual path
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line); // replace System.out.println with your security-sensitive operation
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}