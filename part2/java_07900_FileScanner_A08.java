import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;

public class java_07900_FileScanner_A08 {

    public static void main(String[] args) {
        String dirPath = "/path/to/directory"; // replace with your directory path
        String extension = ".txt";
        File dir = new File(dirPath);

        findFiles(dir, extension);
    }

    public static void findFiles(File dir, String extension) {
        File[] files = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(extension);
            }
        });

        if (files != null) {
            for (File file : files) {
                System.out.println("File: " + file.getPath());
            }
        } else {
            System.out.println("No files with extension " + extension + " found in directory " + dir.getPath());
        }
    }
}