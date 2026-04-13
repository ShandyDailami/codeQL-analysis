import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_19846_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("path/to/your/file.txt"); // Replace with your file path
        Scanner scanner = new Scanner(file);

        // Iterate over each line in the file
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }

        scanner.close();
    }
}