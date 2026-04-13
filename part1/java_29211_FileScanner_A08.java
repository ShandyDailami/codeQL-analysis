import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_29211_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("path_to_your_file");
        Scanner scanner = new Scanner(file);

        // Read and print file contents
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }

        scanner.close();
    }
}