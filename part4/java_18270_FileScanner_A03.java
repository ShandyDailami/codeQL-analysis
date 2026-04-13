import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class java_18270_FileScanner_A03 {
    public static void main(String[] args) {
        Set<String> fileNames = new HashSet<>();

        File rootDirectory = new File(".");

        searchFiles(rootDirectory, fileNames);

        for (String fileName : fileNames) {
            System.out.println(fileName);
        }
    }

    private static void searchFiles(File directory, Set<String> fileNames) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    searchFiles(file, fileNames);
                } else {
                    fileNames.add(file.getAbsolutePath());
                }
            }
        }
    }
}