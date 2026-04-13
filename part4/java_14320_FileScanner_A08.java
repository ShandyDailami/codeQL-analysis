import java.io.File;
import java.util.Scanner;

public class java_14320_FileScanner_A08 {
    public static void main(String[] args) {
        File file = new File("C:\\path\\to\\your\\file");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            // This is where you'd handle the line. 
            // For instance, we'd print it to the console
            System.out.println(line);
        }

        scanner.close();
    }
}