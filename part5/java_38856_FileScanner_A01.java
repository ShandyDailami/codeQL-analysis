import java.io.File;
import java.util.Scanner;

public class java_38856_FileScanner_A01 {
    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");
        File file = new File(userDir);
        File[] files = file.listFiles();

        if (files != null) {
            for (File f : files) {
                if (f.isFile()) {
                    System.out.println(f.getAbsolutePath());
                } else {
                    System.out.println("Directory: " + f.getAbsolutePath());
                }
            }
        }
    }
}