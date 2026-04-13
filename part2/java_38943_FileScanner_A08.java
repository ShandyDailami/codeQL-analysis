import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.FileSystem;
import java.nio.file.Paths;

public class java_38943_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "path_to_your_directory"; // Replace with your directory path
        String fileName = "A08_IntegrityFailure.txt";

        try (FileSystem fs = FileSystems.newFileSystem(Paths.get(directoryPath), null)) {
            Path path = fs.getPath(fileName);
            if (fs.exists(path)) {
                Scanner scanner = new Scanner(path);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                }
                scanner.close();
            } else {
                throw new FileNotFoundException("File not found: " + fileName);
            }
        } catch (FileNotFoundException e) {
            System.err.println("FileNotFoundException: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}