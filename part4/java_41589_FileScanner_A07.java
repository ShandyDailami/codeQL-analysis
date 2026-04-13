import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_41589_FileScanner_A07 {

    public static void main(String[] args) {
        String directoryPath = "path/to/directory"; // replace with your directory path
        String fileName = "file.txt"; // replace with your file name

        File directory = new File(directoryPath);
        File file = new File(directory, fileName);

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getPath());
        }
    }
}