import java.io.File;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class java_30141_FileScanner_A07 extends SimpleFileVisitor<Path> {

    private boolean isFileFound = false;
    private String fileType;

    public java_30141_FileScanner_A07(String fileType) {
        this.fileType = fileType;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        if (file.toString().endsWith(fileType)) {
            isFileFound = true;
            System.out.println("File found: " + file.toString());
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) {
        System.out.println("Failed to access file: " + file.toString());
        return FileVisitResult.CONTINUE;
    }

    public static void main(String[] args) {
        MyFileScanner fileScanner = new MyFileScanner(".txt");
        Path startPath = Paths.get("path_to_directory");

        try (DirectoryStream<Path> ds = Files.newDirectoryStream(startPath, ".*" + fileScanner.fileType)) {
            for (Path path : ds) {
                fileScanner.traverse(path);
                if (fileScanner.isFileFound) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}