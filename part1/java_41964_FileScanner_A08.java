import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_41964_FileScanner_A08 {
    public static void main(String[] args) {
        try {
            // Create a Scanner for reading files
            Scanner scanner = new Scanner(new File("src/main/resources/file.txt"));

            // While there are more tokens to read, print them
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

            // Close the scanner
            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}