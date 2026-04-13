import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_09125_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        String directoryPath = "./src"; // Replace with your directory path
        File directory = new File(directoryPath);

        printDirectoryContent(directory);
    }

    private static void printDirectoryContent(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        System.out.println(scanner.nextLine());
                    }
                    scanner.close();
                } else if (file.isDirectory()) {
                    printDirectoryContent(file);
                }
            }
        }
    }
}