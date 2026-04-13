import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_22552_FileScanner_A01 {
    public static void main(String[] args) {
        File file = new File("sample_file.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // This line will fail in a security-sensitive operation.
                // The scanner cannot read a file if the file does not exist.
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("The file " + file.getName() + " was not found.");
        }
    }
}