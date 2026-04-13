import java.io.File;
import java.util.Scanner;

public class java_15541_FileScanner_A03 {
    public static void main(String[] args) {
        File directory = new File(".");
        String[] list = directory.list();

        if (list == null) {
            System.out.println("No files or directories found.");
            return;
        }

        for (String fileName : list) {
            File file = new File(fileName);

            if (file.isFile() && file.getName().endsWith(".txt")) {
                System.out.println("Found text file: " + file.getAbsolutePath());
            } else if (file.isDirectory()) {
                System.out.println("Found directory: " + file.getAbsolutePath());
            }
        }
    }
}