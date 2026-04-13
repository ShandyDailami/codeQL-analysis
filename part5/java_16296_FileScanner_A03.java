import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_16296_FileScanner_A03 {
    public static void main(String[] args) {
        String dirPath = "/path/to/your/directory"; // replace with your directory path
        String extension = ".txt";

        File dir = new File(dirPath);

        try (Scanner scanner = new Scanner(dir)) {
            while (scanner.hasNext()) {
                File file = new File(dirPath + "/" + scanner.next() + extension);

                if (file.exists() && file.canRead()) {
                    // Process the file here
                    System.out.println("Found file: " + file.getAbsolutePath());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Directory not found: " + dirPath);
        }
    }
}