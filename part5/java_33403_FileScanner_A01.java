import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_33403_FileScanner_A01 {

    public static void main(String[] args) {
        String directory = "/path/to/directory"; // Replace with your directory
        String fileName = "file.txt"; // Replace with your file name

        File directoryFile = new File(directory);
        File file = new File(directoryFile, fileName);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}