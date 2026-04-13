import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_26400_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("target/path/to/directory"); // provide your directory path here

        if (file.exists()) {
            for (File item : file.listFiles()) {
                if (item.getName().endsWith(".txt")) { // filter for text files
                    if (item.length() > 1024) { // filter for files over 1024 bytes
                        System.out.println("File: " + item.getName());
                        System.out.println("Size: " + item.length() + " bytes");
                    }
                }
            }
        } else {
            System.out.println("The specified file does not exist.");
        }
    }
}