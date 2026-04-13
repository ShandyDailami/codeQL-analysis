import java.io.File;
import java.util.Scanner;

public class java_07720_FileScanner_A01 {
    public static void main(String[] args) {
        File currentDir = new File(".");
        String[] list = currentDir.list();
        if (list != null) {
            for (String filename : list) {
                File file = new File(filename);
                // Print filename and its size
                System.out.println("File: " + file.getName() + ", Size: " + file.length() + " bytes");
            }
        } else {
            System.out.println("Current directory is empty.");
        }
    }
}