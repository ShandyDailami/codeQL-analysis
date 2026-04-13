import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class java_33581_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // Replace with your directory path

        File directory = new File(directoryPath);

        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return !pathname.isHidden() && pathname.isFile();
            }
        };

        File[] files = directory.listFiles(fileFilter);

        if (files != null) {
            Arrays.stream(files).forEach(file -> System.out.println(file.getAbsolutePath()));
        } else {
            System.out.println("No files found in the specified directory.");
        }
    }
}