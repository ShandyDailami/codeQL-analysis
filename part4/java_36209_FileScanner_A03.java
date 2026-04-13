import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_36209_FileScanner_A03 {
    public static void main(String[] args) {
        File directory = new File(".");
        String[] fileList = directory.list();

        // If directory not found, return
        if (fileList == null) {
            System.out.println("Directory not found.");
            return;
        }

        for (String fileName : fileList) {
            File file = new File(fileName);

            // Ignore hidden files
            if (file.isHidden()) {
                continue;
            }

            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + fileName);
            }
        }
    }
}