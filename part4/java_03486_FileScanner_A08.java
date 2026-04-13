import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_03486_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File("."); // current directory
        String[] list = directory.list();

        if (list != null) {
            for (String fileName : list) {
                File file = new File(fileName);
                if (file.isFile()) {
                    System.out.println("File: " + fileName);
                    System.out.println("Size: " + file.length() + " bytes");
                }
            }
        }
    }
}