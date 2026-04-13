import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class java_38730_FileScanner_A07 {
    public static void main(String[] args) {
        String directoryPath = "path/to/directory"; // replace with your directory path
        String fileExtension = ".txt"; // replace with your file extension

        File directory = new File(directoryPath);

        File[] files = directory.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(fileExtension);
            }
        });

        if (files != null) {
            Arrays.stream(files).forEach(file -> System.out.println(file.getAbsolutePath()));
        } else {
            System.out.println("No files found with the specified extension.");
        }
    }
}