import java.io.File;
import java.util.Scanner;

public class java_41187_FileScanner_A01 {
    public static void main(String[] args) {
        String currentDir = System.getProperty("user.dir");
        String filePath = currentDir + "/example.txt";
        File file = new File(filePath);

        if (file.exists()) {
            System.out.println("Success: The file 'example.txt' exists in the current directory.");
        } else {
            System.out.println("Error: The file 'example.txt' does not exist in the current directory.");
        }
    }
}