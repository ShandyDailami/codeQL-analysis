import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_08656_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a file scanner
        Scanner fileScanner = new Scanner(new File("src/main/resources/textfile.txt"));

        // Use the file scanner to read file content
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            System.out.println(line);
        }

        // Close the file scanner
        fileScanner.close();
    }
}