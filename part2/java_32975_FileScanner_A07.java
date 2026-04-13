import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_32975_FileScanner_A07 {
    public static void main(String[] args) {
        // Specify the directory path
        String directoryPath = "/path/to/your/directory";

        File directory = new File(directoryPath);

        // Use a recursive approach to find all files in the directory
        scanDirectory(directory);
    }

    private static void scanDirectory(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanDirectory(file);
                } else if (file.isFile()) {
                    scanFile(file);
                }
            }
        }
    }

    private static void scanFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}