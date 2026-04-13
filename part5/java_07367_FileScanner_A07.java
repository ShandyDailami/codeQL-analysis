import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class java_07367_FileScanner_A07 {
    public static void main(String[] args) {
        String dir = "/path/to/directory"; // Replace with your directory path
        String extension = ".txt"; // Replace with your file extension
        listFiles(dir, extension);
    }

    public static void listFiles(String dir, final String extension) {
        FileFilter fileFilter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(extension);
            }
        };

        File directory = new File(dir);
        File[] files = directory.listFiles(fileFilter);

        if (files != null) {
            for (File file : files) {
                System.out.println(file.getAbsolutePath());
            }
        }
    }
}