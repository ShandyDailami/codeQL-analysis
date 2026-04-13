import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_08175_FileScanner_A01 {
    public static void main(String[] args) {
        try {
            // This is a security-sensitive operation
            File file = new File("sampleFile.txt");

            // Creating a new Scanner object
            Scanner scanner = new Scanner(file);

            // Reading the file and printing out each line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

            // Closing the scanner
            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}