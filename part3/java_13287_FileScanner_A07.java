import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_13287_FileScanner_A07 {

    private static final String FILE_PATH = "C:\\path\\to\\directory"; // Replace with your directory path

    public static void main(String[] args) {
        File directory = new File(FILE_PATH);
        try {
            Scanner scanner = new Scanner(directory);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // You can handle the line here. For example, print it or check if it's a file to handle.
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}