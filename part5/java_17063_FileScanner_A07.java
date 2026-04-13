import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class java_17063_FileScanner_A07 {

    public static void main(String[] args) throws IOException {
        String directoryPath = "/path/to/your/directory"; // Replace with your directory path
        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] listOfFiles = directory.listFiles();

            if (listOfFiles != null) {
                for (File file : listOfFiles) {
                    if (file.isFile()) {
                        Path path = Paths.get(file.getPath());
                        System.out.println(path.toString());
                    }
                }
            }
        }
    }
}