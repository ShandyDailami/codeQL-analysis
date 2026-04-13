import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_40732_FileScanner_A08 {

    public static void main(String[] args) {

        // Create a FileScanner to read files from a directory.
        FileScanner scanner = new FileScanner();

        // Use the scanner to find a file in the current directory named "input.txt".
        File file = scanner.findFile("input.txt");

        // If the file exists, print its contents.
        if (file != null) {
            System.out.println("File contents:");
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    System.out.println(scanner.nextLine());
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found!");
            }
        } else {
            System.out.println("File not found!");
        }

    }
}