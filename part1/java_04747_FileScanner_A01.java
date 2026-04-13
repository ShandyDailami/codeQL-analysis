import java.io.File;
import java.util.Arrays;

public class java_04747_FileScanner_A01 {
    public static void main(String[] args) {
        File currentDir = new File(".");

        // List all files in the current directory
        File[] files = currentDir.listFiles();

        if (files != null) {
            Arrays.stream(files).forEach(file -> {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getName());
                }
            });
        }
    }
}