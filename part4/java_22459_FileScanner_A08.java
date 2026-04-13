import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;

public class java_22459_FileScanner_A08 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";
        String targetFile = "target_file.txt";

        File directory = new File(directoryPath);

        FileFilter fileFilter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.getName().equals(targetFile);
            }
        };

        FilenameFilter filenameFilter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.equals(targetFile);
            }
        };

        File[] relevantFiles = directory.listFiles(fileFilter);
        String[] relevantFileNames = Arrays.stream(relevantFiles)
                .map(File::getName)
                .toArray(String[]::new);

        if (Arrays.asList(relevantFileNames).contains(targetFile)) {
            System.out.println("Target file found: " + targetFile);
        } else {
            System.out.println("Target file not found: " + targetFile);
        }
    }
}