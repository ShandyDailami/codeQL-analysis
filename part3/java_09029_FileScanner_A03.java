import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_09029_FileScanner_A03 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace this with your directory path
        scanDirectory(directoryPath);
    }

    private static void scanDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    printFileContents(file);
                } else if (file.isDirectory()) {
                    scanDirectory(file.getPath());
                }
            }
        }
    }

    private static void printFileContents(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file: " + file.getName());
        }
    }
}