import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class java_31419_FileScanner_A08 {
    public static void main(String[] args) {
        File directory = new File(".");
        Set<String> files = new HashSet<>();
        scanDirectory(directory, files);

        // Remove all comments to make the code syntactically correct
        for (String file : files) {
            System.out.println(file);
        }
    }

    private static void scanDirectory(File directory, Set<String> files) {
        File[] listFiles = directory.listFiles();

        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isDirectory()) {
                    scanDirectory(file, files);
                } else {
                    files.add(file.getAbsolutePath());
                }
            }
        }
    }
}