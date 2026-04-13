import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_37604_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "./src/main/java"; // replace with your directory path

        File directory = new File(directoryPath);

        if (directory.exists()) {
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
}