import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_16444_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a FileScanner to read the text file
        Scanner scanner = new Scanner(new File("text.txt"));

        // Use a while loop to read and print all words in the file
        while (scanner.hasNext()) {
            String word = scanner.next();
            System.out.println(word);
        }

        // Close the scanner
        scanner.close();
    }
}