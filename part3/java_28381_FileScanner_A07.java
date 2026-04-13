import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_28381_FileScanner_A07 {
    public static void main(String[] args) {
        File file = new File("path/to/your/file"); // replace with your file path
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("A07_AuthFailure")) {
                    System.out.println("The file contains the string 'A07_AuthFailure'");
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file does not exist!");
        }
    }
}