import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_05058_FileScanner_A01 {

    private static final String FILE_PATH = "path/to/file"; // Replace with your actual file path

    public static void main(String[] args) {
        File file = new File(FILE_PATH);
        Scanner scanner = null;

        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + FILE_PATH);
            return;
        }

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }

        scanner.close();
    }
}