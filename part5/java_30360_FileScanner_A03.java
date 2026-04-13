import java.io.File;
import java.io.FilenameFilter;

public class java_30360_FileScanner_A03 {

    public static void main(String[] args) {
        String directory = ".";
        fileScan(directory, (dir, name) -> name.endsWith(".txt"));
    }

    private static void fileScan(String directory, FilenameFilter filter) {
        File root = new File(directory);
        File[] list = root.listFiles(filter);
        if (list == null) return;
        for (File file : list) {
            if (file.isFile()) {
                System.out.println("File: " + file.getAbsolutePath());
            } else if (file.isDirectory()) {
                fileScan(file.getAbsolutePath(), filter);
            }
        }
    }
}