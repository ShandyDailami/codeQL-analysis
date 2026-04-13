import java.io.File;
import java.io.FileFilter;

public class java_28998_FileScanner_A01 {

    public static void main(String[] args) {
        File file = new File(".");

        // Use a file filter to only list directories
        FileFilter fileFilter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        };

        // List all files in the current directory (and its subdirectories)
        listFiles(file, fileFilter);
    }

    public static void listFiles(File dir, FileFilter fileFilter) {
        File[] files = dir.listFiles(fileFilter);

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    listFiles(file, fileFilter);
                } else {
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
    }
}