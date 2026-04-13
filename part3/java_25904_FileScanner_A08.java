import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_25904_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("."); // represents the current directory
        scanDirectory(file, "");
    }

    private static void scanDirectory(File file, String indent) {
        if (file.isDirectory()) {
            System.out.println(indent + "Directory: " + file.getName());
            String[] list = file.list();
            if (list != null) {
                for (String s : list) {
                    File f = new File(file, s);
                    scanDirectory(f, indent + "  ");
                }
            }
        } else {
            if (file.getName().endsWith(".txt")) {
                System.out.println(indent + "Text file: " + file.getName());
            }
        }
    }
}