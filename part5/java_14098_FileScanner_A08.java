import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_14098_FileScanner_A08 {

    public static void main(String[] args) {
        File directory = new File(".");
        scanDirectory(directory);
    }

    private static void scanDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanDirectory(file);
                } else {
                    scanFile(file);
                }
            }
        }
    }

    private static void scanFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Here you can implement your security-sensitive operation like encryption or decryption.
                // For example, here we just print the line:
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}