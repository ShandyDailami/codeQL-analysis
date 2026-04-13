import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class java_01562_FileScanner_A08 {
    public static void main(String[] args) throws IOException {
        String directoryPath = "path_to_directory"; // replace with your directory path
        File dir = new File(directoryPath);
        fileScan(dir, (File f) -> f.isFile() && !f.isHidden());
    }

    public static void fileScan(File dir, FileFilter filter) {
        if (dir.listFiles(filter).length == 0) {
            System.out.println("No files found in directory " + dir.getAbsolutePath());
        } else {
            for (File file : dir.listFiles(filter)) {
                System.out.println("Found file: " + file.getAbsolutePath());
                // Here you would typically add code to check the file's integrity,
                // but since this is not a secure system, I'll just print out the file's size
                try (Stream<String> stream = Files.lines(Paths.get(file.getAbsolutePath()))) {
                    long lines = stream.count();
                    System.out.println("Number of lines: " + lines);
                } catch (IOException e) {
                    System.out.println("Error reading file " + file.getAbsolutePath());
                }
            }
        }
    }
}