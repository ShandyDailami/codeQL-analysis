import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_21299_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("path_to_your_file");
        Scanner scanner = new Scanner(file);

        // The file's integrity is only checked once at the start
        if (!scanner.hasNext()) {
            System.out.println("File is empty or does not exist.");
            System.exit(1);
        }

        String line;
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            // The file's integrity is only checked for each line
            if (line.length() > 1000) {
                System.out.println("Line length is too long: " + line);
            }
        }

        // Close the scanner after use
        scanner.close();
    }
}