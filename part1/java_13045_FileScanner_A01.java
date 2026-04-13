import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class java_13045_FileScanner_A01 {

    public List<File> findFiles(String directoryPath, String extension) {
        File directory = new File(directoryPath);
        List<File> files = new ArrayList<>();
        File[] foundFiles = directory.listFiles((dir, name) -> name.endsWith(extension));

        if (foundFiles != null) {
            for (File file : foundFiles) {
                files.add(file);
            }
        }

        return files;
    }
}