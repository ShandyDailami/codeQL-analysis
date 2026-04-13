import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_00491_FileScanner_A03 {
    public static void main(String[] args) {
        String filePath = "/path/to/file";  // replace with your file path

        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("File not found!");
            return;
        }

        try (Scanner scanner = new Scanner(file)) {
            int lineNumber = 0;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lineNumber++;
                System.out.println("Line " + lineNumber + ": " + line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}