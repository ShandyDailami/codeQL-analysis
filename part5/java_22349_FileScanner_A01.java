import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_22349_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        String dirPath = "/path/to/directory"; // replace with your directory path
        File directory = new File(dirPath);

        if (directory.exists()) {
            for (File file : directory.listFiles()) {
                if (file.isFile() && file.getName().startsWith("A") && !file.getName().startsWith("a")) {
                    System.out.println(file.getName());
                }
            }
        } else {
            System.out.println("Directory not found!");
        }
    }
}