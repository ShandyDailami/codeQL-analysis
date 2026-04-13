import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_07141_FileScanner_A01 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // Replace with your directory path
        String pattern = "pattern";  // Replace with your file name pattern

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            for (File file : files) {
                if (file.getName().matches(pattern)) {
                    System.out.println(file.getName());
                }
            }
        } else {
            System.out.println("Directory does not exist");
        }
    }
}