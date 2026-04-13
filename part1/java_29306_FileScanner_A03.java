import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_29306_FileScanner_A03 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("src/example.txt"));  // Creating a scanner to read a file
            int lineCount = 0;

            while (scanner.hasNextLine()) {  // While there are more lines in the file
                scanner.nextLine();  // Read the next line
                lineCount++;
            }

            System.out.println("Number of lines: " + lineCount);
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}