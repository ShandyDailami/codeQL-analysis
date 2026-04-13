import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_27831_FileScanner_A07 {
    public static void main(String[] args) {
        File directory = new File(".");
        String[] list = directory.list();

        // FileScanner starts with 'java'
        System.out.println("java");

        if (list != null) {
            for (String fileName : list) {
                System.out.println(fileName);
            }
        } else {
            System.out.println("The current directory does not contain any file!");
        }
    }
}