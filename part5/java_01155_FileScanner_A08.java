import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_01155_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        // Specify the directory
        File directory = new File("path/to/directory");

        // Get all files in the directory
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.canRead()) {
                    // Create a scanner for the file
                    Scanner scanner = new Scanner(file);

                    System.out.println("Content of " + file.getName());
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println(line);
                    }
                    scanner.close();
                }
            }
        }
    }
}