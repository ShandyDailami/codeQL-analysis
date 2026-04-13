import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_15324_FileScanner_A01 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("example.txt"));  // Reading the file into a scanner
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());  // Printing the content of the file
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}