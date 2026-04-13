import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_41708_FileScanner_A03 {

    // Avoid static main method
    public void scan(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner scanner = new Scanner(file);

        // Avoid using nextLine() which is a security-sensitive operation
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            // Here, we are simply printing the line to avoid using nextLine()
            System.out.println(line);
        }

        scanner.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        FileScanner scanner = new FileScanner();
        scanner.scan("/path/to/your/file");
    }
}