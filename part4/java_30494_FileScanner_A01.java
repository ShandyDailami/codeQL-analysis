import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

public class java_30494_FileScanner_A01 {
    public static void main(String[] args) {
        File root = new File("/path/to/root");
        String extension = ".*"; // example
        FileFilter filter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(extension);
            }
        };
        List<File> files = new ArrayList<File>();
        scan(root, filter, files);
        for (File file : files) {
            System.out.println(file.getAbsolutePath());
        }
    }

    private static void scan(File root, FileFilter filter, List<File> files) {
        File[] listFiles = root.listFiles(filter);
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isDirectory()) {
                    scan(file, filter, files);
                } else {
                    files.add(file);
                }
            }
        }
    }
}