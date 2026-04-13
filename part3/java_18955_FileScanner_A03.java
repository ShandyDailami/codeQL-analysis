import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_18955_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        String directoryPath = "/path/to/directory";  // replace with your directory path
        File directory = new File(directoryPath);

        if (directory.exists()) {
            printFilesInDirectory(directory);
        } else {
            System.out.println("Directory does not exist");
        }
    }

    private static void printFilesInDirectory(File directory) throws FileNotFoundException {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    printFile(file);
                } else if (file.isDirectory()) {
                    printFilesInDirectory(file);
                }
            }
        }
    }

    private static void printFile(File file) throws FileNotFoundException {
        if (file.canRead()) {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    System.out.println(scanner.nextLine());
                }
            }
        } else {
            System.out.println("Cannot read file: " + file.getAbsolutePath());
        }
    }
}