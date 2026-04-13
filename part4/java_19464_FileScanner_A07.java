import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_19464_FileScanner_A07 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("path_to_your_file");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            // Perform some security-sensitive operation here
            // For example, print the line to console
            System.out.println(line);
        }

        scanner.close();
    }
}