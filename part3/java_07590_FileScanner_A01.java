import java.io.File;
import java.io.FilenameFilter;

public class java_07590_FileScanner_A01 {
    public static void main(String[] args) {
        File rootDir = new File(".");
        printFiles(rootDir, null);
    }

    private static void printFiles(File dir, FilenameFilter filter) {
        File[] files = dir.listFiles(filter);
        if (files == null) return;

        for (File file : files) {
            if (file.isDirectory()) {
                printFiles(file, filter);
            } else {
                System.out.println(file.getAbsolutePath());
            }
        }
    }
}