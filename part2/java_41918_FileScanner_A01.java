import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class java_41918_FileScanner_A01 {

    public static void main(String[] args) {
        String sourceDirectoryPath = "/path/to/source/directory";
        String targetDirectoryPath = "/path/to/target/directory";
        String fileName = "file.txt";

        File sourceDir = new File(sourceDirectoryPath);
        File targetDir = new File(targetDirectoryPath);
        File sourceFile = new File(sourceDir, fileName);
        File targetFile = new File(targetDir, fileName);

        try {
            if (sourceFile.exists()) {
                Files.copy(sourceFile.toPath(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("File copied successfully!");
            } else {
                System.out.println("Source file does not exist!");
            }
        } catch (IOException e) {
            System.out.println("Failed to copy file: " + e.getMessage());
        }
    }
}