import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_05845_FileScanner_A08 {
    private static final String FILE_PATH = "data.txt";

    public static void main(String[] args) {
        try {
            File file = new File(FILE_PATH);
            if (file.exists()) {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                    // Perform integrity check here (e.g., SHA-256 hash of the line, etc.)
                    // If the integrity check fails, handle the error (e.g., print an error message and terminate the program)
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