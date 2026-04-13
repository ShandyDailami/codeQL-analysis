import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_05639_FileScanner_A08 {
    public static void main(String[] args) {
        try {
            // Create a File instance for the current file
            File file = new File("test.txt");

            // Check if the file exists
            if (file.exists()) {
                // Create a Scanner for reading the file
                Scanner scanner = new Scanner(file);

                // Print out the content of the file
                while (scanner.hasNext()) {
                    System.out.println(scanner.nextLine());
                }
                scanner.close();
            } else {
                System.out.println("File not found!");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}