import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_39490_FileScanner_A03 {
    public static void main(String[] args) {
        File directory = new File("."); // Current directory
        File[] files = directory.listFiles();

        if (files != null) {
            Arrays.sort(files);
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                }
            }
        }
    }
}