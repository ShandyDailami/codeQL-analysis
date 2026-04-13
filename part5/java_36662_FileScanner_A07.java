import java.io.File;
import java.io.FileFilter;
import java.util.Scanner;

public class java_36662_FileScanner_A07 {

    public static void main(String[] args) {
        File file = new File(".");
        printFiles(file, "");
    }

    public static void printFiles(File dir, String indent) {
        File[] list = dir.listFiles();
        if (list == null) {
            return;
        }

        for (File file : list) {
            if (file.isDirectory()) {
                printFiles(file, indent + "--");
            } else {
                System.out.println(indent + file.getName());
            }
        }
    }
}