import java.io.File;
import java.io.FileFilter;

public class java_04885_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";
        File dir = new File(directoryPath);

        FileFilter txtFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        };

        printFilesInDirectory(dir, txtFilter);
    }

    private static void printFilesInDirectory(File dir, FileFilter filter) {
        File[] files = dir.listFiles(filter);
        if (files != null) {
            for (File file : files) {
                System.out.println(file.getAbsolutePath());
            }
        }
    }
}