import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_28272_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        String directoryPath = "path_to_your_directory";
        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] allFiles = directory.listFiles();

            if (allFiles != null) {
                for (File file : allFiles) {
                    if (file.isFile()) {
                        System.out.println("File Name: " + file.getName());
                    }
                }
            }
        }
    }
}