import java.io.File;
import java.io.IOException;

public class java_30949_FileScanner_A03 {
    public static void main(String[] args) throws IOException {
        File directory = new File(".");
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                    System.out.println("Size: " + file.length() + " bytes");
                }
            }
        }
    }
}