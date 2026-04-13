import java.io.File;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_19566_FileScanner_A08 {

    private static final SecureRandom rand = new SecureRandom();
    private static final String DIRECTORY = "C:/";

    public static void main(String[] args) {
        File file = new File(DIRECTORY);
        List<String> fileNames = new ArrayList<>();
        scanDirectory(file, fileNames);
        fileNames.forEach(System.out::println);
    }

    private static void scanDirectory(File directory, List<String> fileNames) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanDirectory(file, fileNames);
                } else {
                    fileNames.add(file.getName());
                }
            }
        }
    }
}