import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_06126_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        String fileName = "file.txt"; // replace with your file name

        File directory = new File(directoryPath);
        File file = new File(directory, fileName);

        if (file.exists()) {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        } else {
            System.out.println("File not found.");
        }
    }
}