import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;

public class java_03747_FileScanner_A08 {
    public static void main(String[] args) {
        File directory = new File(".");
        findFiles(directory, (file) -> file.isFile() && file.getName().endsWith(".txt"));
    }

    private static void findFiles(File directory, FilenameFilter filter) {
        File[] files = directory.listFiles(filter);
        if (files != null) {
            Arrays.stream(files).forEach(Main::printFileInfo);
        }

        File[] subDirectories = directory.listFiles(File::isDirectory);
        if (subDirectories != null) {
            Arrays.stream(subDirectories).forEach(dir -> findFiles(dir, filter));
        }
    }

    private static void printFileInfo(File file) {
        System.out.println("File: " + file.getAbsolutePath());
    }
}