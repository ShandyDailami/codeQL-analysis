import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_20142_FileScanner_A03 {

    public static void main(String[] args) {
        String directory = "/path/to/directory"; // replace with actual directory
        String extension = "txt"; // replace with actual extension

        File dir = new File(directory);
        File[] listOfFiles = dir.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile() && file.getName().endsWith(extension)) {
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        // process the line here
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("File not found: " + file.getName());
                }
            }
        }
    }
}