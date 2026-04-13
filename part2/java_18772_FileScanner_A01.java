import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_18772_FileScanner_A01 {

    public static void main(String[] args) {
        String directory = "/path/to/directory"; // specify the directory
        String fileName = "file.txt"; // specify the file name
        File file = new File(directory, fileName);
        Scanner scanner = null;

        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}