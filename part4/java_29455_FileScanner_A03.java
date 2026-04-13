import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_29455_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        String directoryPath = "/path/to/directory"; // Replace with your directory path

        File directory = new File(directoryPath);

        if (directory.exists()) {
            searchTextFiles(directory);
        } else {
            System.out.println("Directory does not exist.");
        }
    }

    private static void searchTextFiles(File directory) throws FileNotFoundException {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println(line);
                    }
                    scanner.close();
                } else if (file.isDirectory()) {
                    searchTextFiles(file);
                }
            }
        }
    }
}