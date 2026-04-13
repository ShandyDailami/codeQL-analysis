import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_01074_FileScanner_A01 {

    public static void main(String[] args) {
        FileScanner scanner = new FileScanner();
        scanner.scan("", ".");
    }

    private void scan(String dir, String prefix) {
        File folder = new File(dir);
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    System.out.println(prefix + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println(prefix + file.getName() + "/");
                    scan(file.getPath(), prefix + file.getName() + "/");
                }
            }
        }
    }
}