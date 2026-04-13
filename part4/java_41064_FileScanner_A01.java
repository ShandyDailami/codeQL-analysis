import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;

public class java_41064_FileScanner_A01 {

    public static void main(String[] args) throws IOException {
        String directory = ".";
        fileScan(directory, (file) -> file.isFile() && file.length() > 500 && file.getName().endsWith(".txt"));
    }

    private static void fileScan(String directory, FilenameFilter filter) throws IOException {
        File files[] = new File(directory).listFiles(filter);

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getAbsolutePath());
                } else {
                    fileScan(file.getAbsolutePath(), filter);
                }
            }
        }
    }
}