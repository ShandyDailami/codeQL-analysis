import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_17600_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("./test_files");
        if (file.exists()) {
            if (file.isDirectory()) {
                System.out.println("The directory contains the following files:");
                String[] files = file.list();
                for (String name : files) {
                    System.out.println(name);
                }
            } else {
                System.out.println("The file does not exist!");
            }
        } else {
            System.out.println("The directory does not exist!");
        }
    }
}