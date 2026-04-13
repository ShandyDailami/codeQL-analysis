import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class java_11351_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "path/to/directory"; // replace with your directory path
        File directory = new File(directoryPath);

        FileFilter textFilesFilter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.getName().toLowerCase().endsWith(".txt");
            }
        };

        File[] textFiles = directory.listFiles(textFilesFilter);
        if (textFiles != null) {
            Arrays.stream(textFiles).forEach(file -> System.out.println(file.getName()));
        }
    }
}