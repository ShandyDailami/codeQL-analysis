import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_06588_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(".");
        scanDirectory(file);
    }

    private static void scanDirectory(File directory) throws FileNotFoundException {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanDirectory(file);
                } else {
                    Scanner scanner = new Scanner(file);
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