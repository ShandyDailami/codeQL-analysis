import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_11829_FileScanner_A03 {
    public static void main(String[] args) {
        // Specify the directory to scan
        String directory = "/path/to/directory";
        File dir = new File(directory);

        // Specify the file to scan
        String file = "/path/to/file";
        File fileToScan = new File(file);

        try (Scanner scanner = new Scanner(fileToScan)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println("Line: " + line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}