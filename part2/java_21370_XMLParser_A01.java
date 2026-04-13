import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class java_21370_XMLParser_A01 {

    private List<String> files = new ArrayList<>();
    private String currentDir;

    public java_21370_XMLParser_A01(String directory) {
        this.currentDir = directory;
        populateFileList(directory);
    }

    private void populateFileList(String directory) {
        File file = new File(directory);
        File[] listOfFiles = file.listFiles();

        for (File f : listOfFiles) {
            if (f.isFile()) {
                files.add(f.getPath());
            } else if (f.isDirectory()) {
                populateFileList(f.getPath());
            }
        }
    }

    public boolean isAllowedAccess(String filePath) {
        return files.contains(filePath) || files.contains(currentDir + "/" + filePath);
    }
}