import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_22815_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/your/directory";
        String fileName = "file.txt";

        File directory = new File(directoryPath);
        File file = new File(directory, fileName);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getPath());
        }
    }
}