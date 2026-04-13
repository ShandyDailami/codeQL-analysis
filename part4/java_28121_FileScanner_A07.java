import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_28121_FileScanner_A07 {
    public static void main(String[] args) {
        try {
            File file = new File("path_to_directory");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // This is a security-sensitive operation that could fail.
                // You should replace this with your own authentication mechanism.
                if (line.contains("failure")) {
                    System.out.println("Authentication failure detected!");
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("The specified file does not exist.");
        }
    }
}