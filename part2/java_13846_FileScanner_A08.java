import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class java_13846_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = args[0];
        File rootDirectory = new File(directoryPath);

        FileFilter txtFilter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        };

        scanDirectory(rootDirectory, txtFilter);
    }

    private static void scanDirectory(File directory, FileFilter filter) {
        File[] files = directory.listFiles(filter);

        if (files != null) {
            Arrays.stream(files).forEach(FileScanner::printFilePath);
        }

        Arrays.stream(directory.listFiles()).forEach(FileScanner::scanDirectory);
    }

    private static void printFilePath(File file) {
        System.out.println(file.getAbsolutePath());
    }
}