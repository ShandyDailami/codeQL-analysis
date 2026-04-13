import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_11479_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";
        String fileName = "filename.txt";

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