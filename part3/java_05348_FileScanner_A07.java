import java.io.File;
import java.util.Scanner;

public class java_05348_FileScanner_A07 {
    public static void main(String[] args) {
        String currentDir = System.getProperty("user.dir");
        File directory = new File(currentDir);

        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    long length = file.length();
                    System.out.println(file.getName() + ": " + length + " bytes");
                }
            }
        }
    }
}