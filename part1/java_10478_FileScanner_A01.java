import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_10478_FileScanner_A01 {
    public static void main(String[] args) {
        File directory = new File("/path/to/directory");
        scanDirectory(directory);
    }

    private static void scanDirectory(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    try (Scanner scanner = new Scanner(file)) {
                        while (scanner.hasNextLine()) {
                            System.out.println(scanner.nextLine());
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("Error reading file: " + file.getPath());
                    }
                } else if (file.isDirectory()) {
                    scanDirectory(file);
                }
            }
        }
    }
}