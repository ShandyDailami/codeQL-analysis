import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class java_10793_FileScanner_A01 {
    public static void main(String[] args) throws IOException {
        String directoryPath = "/path/to/directory";
        String extension = ".txt";

        File dir = new File(directoryPath);

        File[] files = dir.listFiles((dir1, name) -> name.endsWith(extension));

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    printFileInfo(file);
                }
            }
        }
    }

    private static void printFileInfo(File file) {
        try {
            Path path = Paths.get(file.getCanonicalPath());
            System.out.println("File name: " + file.getName());
            System.out.println("File path: " + path);
            System.out.println("File size: " + Files.size(path));
            System.out.println("---------------------");
        } catch (IOException e) {
            System.out.println("Error getting canoncial path for file: " + file.getName());
        }
    }
}