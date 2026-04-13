import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class java_12608_FileScanner_A01 {
    private String directoryPath;
    private String fileExtension;

    public java_12608_FileScanner_A01(String directoryPath, String fileExtension) {
        this.directoryPath = directoryPath;
        this.fileExtension = fileExtension;
    }

    public List<String> scanFiles() {
        File directory = new File(directoryPath);
        List<String> fileNames = new ArrayList<>();

        File[] files = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

        for (File file : files) {
            fileNames.add(file.getAbsolutePath());
        }

        return fileNames;
    }
}