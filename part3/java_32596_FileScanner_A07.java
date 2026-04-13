import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class java_32596_FileScanner_A07 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // Replace with your directory path
        File directory = new File(directoryPath);

        // Get all writable files in the directory
        File[] writableFiles = directory.listFiles(file -> file.canWrite() && !file.isDirectory());

        // If no writable files, exit the program
        if (writableFiles == null) {
            System.out.println("No writable files in directory.");
            return;
        }

        // Scan all writable files
        for (File writableFile : writableFiles) {
            System.out.println("Reading file: " + writableFile.getAbsolutePath());

            try (FileReader reader = new FileReader(writableFile)) {
                int content;
                while ((content = reader.read()) != -1) {
                    System.out.print((char) content);
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + writableFile.getAbsolutePath());
            } catch (IOException e) {
                System.out.println("Error reading file: " + writableFile.getAbsolutePath());
            }
        }
    }
}