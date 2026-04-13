import java.io.File;
import java.util.Scanner;

public class java_04736_FileScanner_A03 {

    public static void main(String[] args) {
        File file = new File("."); // get current directory
        printFiles(file);
    }

    public static void printFiles(File file) {
        if (file.isDirectory()) {
            File[] list = file.listFiles();
            for (File f : list) {
                printFiles(f);
            }
        } else {
            System.out.println(file.getAbsolutePath());
        }
    }
}