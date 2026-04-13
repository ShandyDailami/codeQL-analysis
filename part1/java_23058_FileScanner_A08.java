import java.io.File;
import java.util.Scanner;

public class java_23058_FileScanner_A08 {

    public static void main(String[] args) {
        File dir = new File(".");
        countFiles(dir, "");
    }

    public static void countFiles(File directory, String searchString) {
        File[] files = directory.listFiles();
        int count = 0;

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    countFiles(file, searchString);
                } else if (file.getName().contains(searchString)) {
                    count++;
                }
            }
        }

        System.out.println("Number of files containing '" + searchString + "' is " + count);
    }
}