import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class java_34515_FileScanner_A07 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        scanDirectory(directoryPath);
    }

    private static void scanDirectory(String directoryPath) {
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        if (!directory.isDirectory()) {
            System.out.println("Provided path is not a directory");
            return;
        }

        try {
            List<File> listOfFiles = Files.newDirectoryStream(Paths.get(directoryPath), "*.txt").toList();

            for (File file : listOfFiles) {
                String absolutePath = file.getAbsolutePath();
                System.out.println("File name: " + file.getName());
                System.out.println("Absolute path: " + absolutePath);
                System.out.println("File size: " + file.length() + " bytes");
                System.out.println("File last modified: " + file.lastModified() + "\n");
            }

            System.out.println("Number of files scanned: " + listOfFiles.size());

        } catch (IOException e) {
            System.out.println("Error scanning directory: " + e.getMessage());
        }
    }
}