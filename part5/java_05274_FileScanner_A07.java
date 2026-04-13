import java.io.File;
import java.nio.file.Path;
import java.util.Scanner;

public class java_05274_FileScanner_A07 {

    public static void main(String[] args) throws Exception {
        // create a Path object to represent the file
        Path filePath = Path.of("path_to_your_file.txt");

        // check if the file exists
        if (!Files.exists(filePath)) {
            System.out.println("File does not exist");
            return;
        }

        // create a Scanner object to read the file
        try (Scanner scanner = new Scanner(filePath)) {
            int lineNumber = 1;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println("Line " + lineNumber + ": " + line);
                lineNumber++;
            }
        }
    }
}