import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_06357_FileScanner_A07 {
    public static void main(String[] args) {
        // Create a new File object for the input file
        File inputFile = new File("input.txt");

        try (Scanner scanner = new Scanner(inputFile)) {
            // Use a while loop to read the content of the file line by line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found!");
        }
    }
}