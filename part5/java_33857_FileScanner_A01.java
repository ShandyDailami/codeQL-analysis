import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class java_33857_FileScanner_A01 {

    public static void main(String[] args) throws IOException {
        String directoryPath = "path_to_directory"; // replace with your directory path
        String extension = "txt"; // replace with your file extension
        scanDirectory(directoryPath, extension);
    }

    private static void scanDirectory(String directoryPath, String extension) throws IOException {
        File directory = new File(directoryPath);
        if (directory.exists() && directory.isDirectory()) {
            try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(directory.toPath(), "*." + extension)) {
                for (Path path : directoryStream) {
                    File file = path.toFile();
                    if (file.exists() && file.canRead()) {
                        FileUtils.copyFile(file, System.out);
                    } else {
                        System.out.println("Unable to read file: " + file.getAbsolutePath());
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist or is not a directory: " + directoryPath);
        }
    }

}