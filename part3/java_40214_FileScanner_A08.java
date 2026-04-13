import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_40214_FileScanner_A08 {

    public static void main(String[] args) {
        File directory = new File(".");

        try {
            Scanner scanner = new Scanner(directory.getCanonicalFile());
            while (scanner.hasNext()) {
                String filename = scanner.next();
                File file = new File(filename);

                // Only print files that are in the current directory
                if (file.isFile()) {
                    System.out.println("File: " + filename);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Directory not found: " + e.getMessage());
        }
    }
}