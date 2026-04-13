import java.io.File;
import java.io.FilenameFilter;
import java.io.FileFilter;

public class java_04908_FileScanner_A07 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";
        String pattern = "pattern.txt";

        File directory = new File(directoryPath);

        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(pattern);
            }
        };

        File[] files = directory.listFiles(fileFilter);

        if (files != null) {
            for (File file : files) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("No files found with the pattern: " + pattern);
        }
    }
}