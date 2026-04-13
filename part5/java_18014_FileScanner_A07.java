import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_18014_FileScanner_A07 {
    public static void main(String[] args) {
        // Specify the directory to scan
        File dir = new File(".");

        // Use a try-with-resources statement to automatically close the scanner when done
        try (Scanner scanner = new Scanner(dir.listFiles())) {
            // Use a while-loop to read all the files in the directory
            while (scanner.hasNext()) {
                String fileName = scanner.next();
                System.out.println(fileName);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}