import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_15713_FileScanner_A03 {
    public static void main(String[] args) {
        // File path should be securely handled
        File file = new File("C:\\path\\to\\file.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Reading the file line by line
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            // Security-sensitive operation here
            // For example, we just print out the line
            System.out.println(line);
        }

        scanner.close();
    }
}