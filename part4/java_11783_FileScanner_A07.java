import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_11783_FileScanner_A07 {

    public static void main(String[] args) {
        // Specify the directory
        File dir = new File(".");

        // Create a FileScanner to scan the directory
        try {
            FileScanner scanner = new FileScanner(dir, true, FileFilter.suffix("txt"));

            // Read through each file in the directory
            while (scanner.hasNext()) {
                File file = scanner.nextFile();
                Scanner fileScanner = new Scanner(file);

                // Print the contents of each file
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    System.out.println(line);
                }

                // Close the file scanner
                fileScanner.close();
            }

            // Close the file scanner
            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}