import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_01912_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File(".");
        printFilesInDirectory(directory);
    }

    public static void printFilesInDirectory(File directory) throws FileNotFoundException {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    printFilesInDirectory(file);
                } else {
                    printFileContent(file);
                }
            }
        }
    }

    public static void printFileContent(File file) throws FileNotFoundException {
        System.out.println("Content of file: " + file.getName());
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        }
    }
}