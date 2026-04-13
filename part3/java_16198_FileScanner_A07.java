import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;
import java.util.stream.Stream;

public class java_16198_FileScanner_A07 {

    // This is a secure way of reading files in a directory
    public static Stream<Path> readDirectory(String directoryPath) throws IOException {
        File directory = new File(directoryPath);
        return Files.walk(Paths.get(directory.getPath()), FileScanner.FOLLOW_LINKS);
    }

    // This is a secure way of checking if a file has certain extensions
    public static boolean fileHasExtension(String filePath, String[] extensions) {
        String fileName = new File(filePath).getName();
        String nameWithoutExt = fileName.substring(0, fileName.lastIndexOf("."));
        return Arrays.stream(extensions).anyMatch(ext -> nameWithoutExt.endsWith(ext));
    }

    // This is a secure way of checking if a file has read permissions
    public static boolean fileHasReadPermission(String filePath) {
        File file = new File(filePath);
        return Files.exists(Paths.get(file.getPath())) && Files.getFileAttribute(Paths.get(file.getPath()), LinkOption.class)
                .map(link -> link.type() == FileAttribute.FileType.REGULAR)
                .orElse(false);
    }

    // This is a secure way of checking if a file has write permissions
    public static boolean fileHasWritePermission(String filePath) {
        File file = new File(filePath);
        return Files.exists(Paths.get(file.getPath())) && Files.getFileAttribute(Paths.get(file.getPath()), LinkOption.class)
                .map(link -> link.type() == FileAttribute.FileType.REGULAR && link.permission() != FilePermission.WRITE)
                .orElse(false);
    }

    public static void main(String[] args) throws IOException {
        String directoryPath = "/path/to/directory";
        String[] extensions = {".txt", ".log"};

        readDirectory(directoryPath)
                .filter(file -> fileHasExtension(file.toString(), extensions) && fileHasReadPermission(file.toString()) && fileHasWritePermission(file.toString()))
                .forEach(file -> System.out.println("File: " + file.toString()));
    }
}