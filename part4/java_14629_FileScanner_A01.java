import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_14629_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File(".");
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                }
            }
        }
    }
}