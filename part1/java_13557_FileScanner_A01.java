import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_13557_FileScanner_A01 {

    public static void main(String[] args) {
        try {
            File file = new File("path_to_file"); // replace with the file you want to scan
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Here we are simply printing the line, but in a security-sensitive operation we should not print the line
                // This is a placeholder for the real operation
                System.out.println(line);
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}