import java.io.File;
import java.io.FileFilter;

public class java_00469_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        String extension = ".txt"; // replace with your extension

        File dir = new File(directoryPath);

        FileFilter filter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(extension);
            }
        };

        File[] files = dir.listFiles(filter);

        if (files != null) {
            for (File file : files) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("No files with extension: " + extension);
        }
    }
}