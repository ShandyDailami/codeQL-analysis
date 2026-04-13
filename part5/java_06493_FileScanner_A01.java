import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class java_06493_FileScanner_A01 {
    public static void main(String[] args) throws IOException {
        File root = new File(".");
        scanDirectory(root);
    }

    private static void scanDirectory(File dir) throws IOException {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanDirectory(file);
                } else if (file.isFile()) {
                    printFile(file);
                }
            }
        }
    }

    private static void printFile(File file) {
        System.out.println("File: " + file.getAbsolutePath());
    }
}