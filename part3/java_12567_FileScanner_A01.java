import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_12567_FileScanner_A01 {

    public static void main(String[] args) throws FileNotFoundException {
        FileScanner scanner = new FileScanner();
        File directory = new File("src");  // replace with your directory
        scanner.scan(directory);
    }
}

class FileScanner {

    public void scan(File directory) throws FileNotFoundException {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".java")) {
                    System.out.println("Found .java file: " + file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    scan(file);
                }
            }
        }
    }
}