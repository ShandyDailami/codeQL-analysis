import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_22098_FileScanner_A08 {
    public static void main(String[] args) {
        try {
            File file = new File("."); // This will point to the current directory.
            FileScanner scanner = new FileScanner(file);

            while (scanner.hasNext()) {
                String fileName = scanner.next();
                System.out.println(fileName);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}