import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_17896_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        String dir = "/path/to/directory"; // replace with your directory path
        File directory = new File(dir);

        if (directory.exists()) {
            File[] foundFiles = directory.listFiles();
            if (foundFiles != null) {
                for (File file : foundFiles) {
                    if (file.isFile()) {
                        System.out.println("File: " + file.getName());
                    }
                }
            }
        }
    }
}