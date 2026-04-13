import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class java_26161_FileScanner_A01 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        Path path = Paths.get(directoryPath);

        try {
            Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    FileNameHelper helper = new FileNameHelper(file.getFileName().toString());

                    if (helper.getExtension().equalsIgnoreCase("txt")) {
                        System.out.println("File found: " + file);
                    }

                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class FileNameHelper {
    private String fileName;

    public java_26161_FileScanner_A01(String fileName) {
        this.fileName = fileName;
    }

    public String getBaseName() {
        return fileName.substring(0, fileName.lastIndexOf('.'));
    }

    public String getExtension() {
        return fileName.substring(fileName.lastIndexOf('.') + 1);
    }
}