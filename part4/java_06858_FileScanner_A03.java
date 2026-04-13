import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_06858_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(".");
        scanFiles(file, "txt");
    }

    public static void scanFiles(File file, String extension) throws FileNotFoundException {
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    scanFiles(f, extension);
                } else if (f.getName().endsWith(extension)) {
                    Scanner scanner = new Scanner(f);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println(line);
                    }
                    scanner.close();
                }
            }
        }
    }
}