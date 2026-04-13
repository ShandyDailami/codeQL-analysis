import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_32373_FileScanner_A03 {

    public static void main(String[] args) {
        File directory = new File(".");
        String[] list = directory.list();
        if (list != null) {
            for (String filename : list) {
                File file = new File(filename);
                if (isFileSafe(file)) {
                    System.out.println("Safe file: " + file.getAbsolutePath());
                }
            }
        }
    }

    public static boolean isFileSafe(File file) {
        // Implement your own logic to check if a file is safe or not
        // For the sake of this example, let's assume all files are safe
        return true;
    }
}