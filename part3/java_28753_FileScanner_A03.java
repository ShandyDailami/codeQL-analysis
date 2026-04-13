import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

public class java_28753_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/your/directory";
        File directory = new File(directoryPath);
        listFiles(directory);
    }

    private static void listFiles(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    listFiles(file);
                } else {
                    printFile(file);
                }
            }
        }
    }

    private static void printFile(File file) {
        System.out.println(file.getAbsolutePath());
    }
}