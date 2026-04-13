import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class java_15859_FileScanner_A03 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        String extension = ".*"; // replace with your file extension
        File directory = new File(directoryPath);
        Set<String> fileNames = new HashSet<>();

        scanDirectory(directory, extension, fileNames);

        // print file names
        for (String fileName : fileNames) {
            System.out.println(fileName);
        }
    }

    private static void scanDirectory(File directory, String extension, Set<String> fileNames) {
        File[] files = directory.listFiles((dir, name) -> name.endsWith(extension));
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    fileNames.add(file.getName());
                } else if (file.isDirectory()) {
                    scanDirectory(file, extension, fileNames);
                }
            }
        }
    }
}