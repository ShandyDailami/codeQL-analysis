import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_17810_FileScanner_A01 {

    // This is the directory we're going to scan
    private static final File DIRECTORY = new File(".");

    public static void main(String[] args) {
        scanDirectory(DIRECTORY);
    }

    /**
     * Scans a directory and its subdirectories recursively.
     *
     * @param directory the directory to scan
     */
    private static void scanDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // If the file is a directory, recursively scan it.
                    scanDirectory(file);
                } else {
                    // If the file is a regular file, scan it.
                    scanFile(file);
                }
            }
        }
    }

    /**
     * Scans a file.
     *
     * @param file the file to scan
     */
    private static void scanFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // This is a very basic security-sensitive operation.
                // It just prints the line to the console.
                // In a real-world application, you would probably want to do something more secure here.
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            // This should never happen if we have a valid directory.
            e.printStackTrace();
        }
    }
}