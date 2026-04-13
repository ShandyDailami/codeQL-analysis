import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_36060_FileScanner_A01 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory/"; // replace with your directory path
        String filePath = "/path/to/file/"; // replace with your file path

        File directory = new File(directoryPath);
        File file = new File(filePath);

        if (directory.canRead() && file.canRead()) {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                }
            } catch (FileNotFoundException e) {
                System.out.println("The file could not be found.");
            }
        } else {
            System.out.println("You don't have permission to read the file.");
        }
    }
}