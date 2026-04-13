import java.nio.file.*;

public class java_21979_FileScanner_A07 {
    public static void main(String[] args) {
        // Initialize the file scanner
        FileSystem fs = FileSystems.getDefault();
        Path match = fs.getPath("./");

        // Use the scanner to find all files
        try (Stream<Path> files = Files.find(match, Integer.MAX_VALUE,
            (p, attrs) -> p.toString().endsWith(".java"))) {

            // Print all the found files
            files.forEach(Main::printFileInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Utility method to print file information
    private static void printFileInfo(Path p) {
        try {
            System.out.println("File: " + p.toString());
            System.out.println("Size: " + Files.size(p));
            System.out.println("Last Modified: " + Files.getLastModifiedTime(p));
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}