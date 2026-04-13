import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_02703_FileScanner_A03 {
    public static void main(String[] args) {
        // Create a FileScanner instance
        FileScanner scanner = new FileScanner();

        // Set the directory path
        scanner.setDirectoryPath("/path/to/your/directory");

        // Use the scanner to scan the directory
        scanner.scanDirectory();

        // Print out the found files and their contents
        for (File file : scanner.getFoundFiles()) {
            System.out.println("Found file: " + file.getName());

            try (Scanner fileScanner = new Scanner(file)) {
                while (fileScanner.hasNextLine()) {
                    System.out.println(fileScanner.nextLine());
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}

class FileScanner {
    private String directoryPath;
    private File[] foundFiles;

    public void setDirectoryPath(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public void scanDirectory() {
        File directory = new File(directoryPath);
        foundFiles = directory.listFiles();
    }

    public File[] getFoundFiles() {
        return foundFiles;
    }
}