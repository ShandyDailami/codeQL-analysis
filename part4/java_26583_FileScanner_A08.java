import java.io.File;
import java.util.Scanner;

public class java_26583_FileScanner_A08 {
    public static void main(String[] args) {
        File directory = new File("."); // Current directory

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println(file.getName());
                    }
                }
            }
        } else {
            System.out.println("The directory does not exist.");
        }
    }
}