import java.io.File;
import java.io.FileFilter;

public class java_18987_FileScanner_A01 {
    public static void main(String[] args) {
        scanDirectory(".", new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isFile();
            }
        });
    }

    public static void scanDirectory(String directory, FileFilter filter) {
        File root = new File(directory);
        File[] list = root.listFiles(filter);
        if (list != null) {
            for (File file : list) {
                if (file.isDirectory()) {
                    scanDirectory(file.getAbsolutePath(), filter);
                } else {
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
    }
}