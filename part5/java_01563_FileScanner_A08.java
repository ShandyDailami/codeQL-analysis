import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class java_01563_FileScanner_A08 {

    public static void main(String[] args) throws IOException {
        FileScanner scanner = new FileScanner("src/main/resources/", "txt");
        File dir = new File("src/main/resources/");
        File[] allFiles = dir.listFiles();

        for (File file : allFiles) {
            if (file.isFile()) {
                Path path = Paths.get(file.getAbsolutePath());
                long size = Files.size(path);
                if (size > 100) {
                    System.out.println("File " + file.getName() + " has a size greater than 100 bytes");
                }
            }
        }
    }
}

class FileScanner {

    private final String directory;
    private final String extension;

    public java_01563_FileScanner_A08(String directory, String extension) {
        this.directory = directory;
        this.extension = extension;
    }

    public void scan() throws IOException {
        File dir = new File(directory);
        File[] allFiles = dir.listFiles((d, name) -> name.endsWith(extension));

        for (File file : allFiles) {
            if (file.isFile()) {
                Path path = Paths.get(file.getAbsolutePath());
                long size = Files.size(path);
                if (size > 100) {
                    System.out.println("File " + file.getName() + " has a size greater than 100 bytes");
                }
            }
        }
    }
}