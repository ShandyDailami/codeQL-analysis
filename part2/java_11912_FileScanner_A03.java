import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

public class java_11912_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        String fileExtension = ".txt"; // replace with your file extension

        File directory = new File(directoryPath);
        List<File> txtFiles = findTxtFiles(directory);

        for (File txtFile : txtFiles) {
            System.out.println("File found: " + txtFile.getAbsolutePath());
        }
    }

    public static List<File> findTxtFiles(File directory) {
        List<File> txtFiles = new ArrayList<>();

        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(fileExtension);
            }
        };

        directory.listFiles(fileFilter); // This line uses the FileFilter

        return txtFiles;
    }
}