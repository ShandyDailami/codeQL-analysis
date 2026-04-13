import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_12549_FileScanner_A01 {

    public static void main(String[] args) throws FileNotFoundException {
        String directoryPath = "/path/to/directory"; // specify your directory here
        File directory = new File(directoryPath);
        scanDirectory(directory);
    }

    private static void scanDirectory(File directory) throws FileNotFoundException {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanDirectory(file);
                } else {
                    printFileContents(file);
                }
            }
        }
    }

    private static void printFileContents(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
        scanner.close();
    }
}