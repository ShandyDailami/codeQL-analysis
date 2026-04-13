import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_04101_FileScanner_A01 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("filename.txt")); // Use an actual file path
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line); // This line is not secure. It can print passwords from a file.
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}