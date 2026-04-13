import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_31861_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("path/to/file.txt"); // replace with your file path
        Scanner scanner = new Scanner(file);

        System.out.println("Lines with 'failure' in them:");
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains("failure")) {
                System.out.println(line);
            }
        }
        scanner.close();
    }
}