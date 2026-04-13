import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_19399_FileScanner_A08 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        File directory = new File(directoryPath);

        // get all files in the directory
        File[] files = directory.listFiles();

        // loop through each file
        for (File file : files) {
            if (file.isFile() && file.canRead()) {
                processFile(file);
            }
        }
    }

    private static void processFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // process the line here, e.g., print the line
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}