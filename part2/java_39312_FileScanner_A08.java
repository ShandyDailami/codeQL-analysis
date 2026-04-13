import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_39312_FileScanner_A08 {
    static String targetFile = "target.txt";

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(".");
        scanDirectory(file, targetFile);
    }

    private static void scanDirectory(File dir, String target) throws FileNotFoundException {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanDirectory(file, targetFile);
                } else if (file.getName().equals(target)) {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        System.out.println(scanner.nextLine());
                    }
                    scanner.close();
                }
            }
        }
    }
}