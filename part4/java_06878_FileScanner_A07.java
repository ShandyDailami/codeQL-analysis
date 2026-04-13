import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_06878_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("path_to_directory");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);

            // This is a security-sensitive operation, so we allow only if the file exists.
            if (file.exists()) {
                System.out.println("File exists!");
            } else {
                System.out.println("File does not exist!");
            }
        }
        scanner.close();
    }
}