import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class java_34423_FileScanner_A08 {
    private static final String DIRECTORY = "C:\\path\\to\\directory";

    public static void main(String[] args) {
        File directory = new File(DIRECTORY);
        printFiles(directory, "");
    }

    private static void printFiles(File directory, String indentation) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    printFiles(file, indentation + "--");
                } else {
                    System.out.println(indentation + file.getName());
                }
            }
        }
    }
}