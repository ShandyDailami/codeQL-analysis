import java.io.File;
import java.util.Scanner;

public class java_32602_FileScanner_A08 {
    public static void main(String[] args) {
        // Create a File object for the input file
        File inputFile = new File("input.txt");

        // Check if the file exists and can be read
        if (inputFile.exists() && inputFile.canRead()) {
            try (Scanner scanner = new Scanner(inputFile)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
               
                }
            }
        } else {
            System.out.println("The input file does not exist or is not readable.");
        }
    }
}