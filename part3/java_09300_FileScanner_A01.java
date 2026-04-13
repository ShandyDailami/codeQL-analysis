import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class java_09300_FileScanner_A01 {

    public static void main(String[] args) {
        try {
            FileSystem fs = FileSystems.getDefaultFileSystem();
            Path startingPath = Paths.get(".");
            printFiles(fs, startingPath, "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printFiles(FileSystem fs, Path path, String indent) {
        FileAttributes attr;
        try {
            attr = fs.readAttributes(path, FileAttributes.class);
            System.out.println(indent + "- " + path.toString());
            if (attr.isDirectory()) {
                File[] files = fs.listFiles(path).orElse(new File[0]);
                for (File file : files) {
                    if (file.canRead()) {
                        printFiles(fs, file.toPath(), indent + "  ");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}