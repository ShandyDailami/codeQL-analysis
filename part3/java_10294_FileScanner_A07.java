import java.io.File;
import java.util.Scanner;

public class java_10294_FileScanner_A07 {
    public static void main(String[] args) {
        File directory = new File(".");
        String[] list = directory.list();

        if (list != null) {
            for (String filename : list) {
                File file = new File(filename);

                // This line is security-sensitive
                if (file.canRead()) {
                    System.out.println("File " + filename + " can be read");
                } else {
                    System.out.println("File " + filename + " cannot be read");
                }
            }
        }
    }
}