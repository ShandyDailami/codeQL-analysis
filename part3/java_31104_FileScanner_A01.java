import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_31104_FileScanner_A01 {

    public static void main(String[] args) throws FileNotFoundException {
        // Create a file scanner to scan for files in the current directory
        FileScanner fileScanner = new FileScanner();

        // Use the scanner to scan the current directory
        String currentDir = System.getProperty("user.dir");
        File directory = new File(currentDir);
        File[] directoryContents = directory.listFiles();
        if (directoryContents != null) {
            for (File file : directoryContents) {
                if (file.isFile()) {
                    fileScanner.scanFile(file);
                }
            }
        }
    }
}

class FileScanner {
    public void scanFile(File file) {
        try {
            // Open the file for reading
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                // Do something with the line
                System.out.println(line);
            }
            // Close the scanner
            fileScanner.close();
        } catch (FileNotFoundException e) {
            // Handle the exception in a creative and realistic way
            System.out.println("Could not open file: " + file.getPath());
        }
    }
}