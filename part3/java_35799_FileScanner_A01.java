import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class java_35799_FileScanner_A01 {
    private static final String ROOT_DIR = ".";

    public static void main(String[] args) {
        File rootDir = new File(ROOT_DIR);
        listFiles(rootDir, (dir, name) -> true);
    }

    private static void listFiles(File dir, FilenameFilter filter) {
        File[] files = dir.listFiles(filter);
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    listFiles(file, filter);
                } else {
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
    }
}