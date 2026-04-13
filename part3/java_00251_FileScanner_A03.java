import java.io.File;
import java.io.FileFilter;

public class java_00251_FileScanner_A03 {

    public static void main(String[] args) {
        String directoryPath = "path_to_directory"; // replace with your directory path
        File dir = new File(directoryPath);
        fileScan(dir, (File file) -> file.getName().endsWith(".java"));
    }

    private static void fileScan(File directory, FileFilter filter) {
        File[] files = directory.listFiles(filter);
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    fileScan(file, filter);
                }
            }
        }
    }
}