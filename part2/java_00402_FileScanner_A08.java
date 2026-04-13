import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_00402_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        String directory = "/path/to/directory";  // Replace with your directory
        File root = new File(directory);
        scanDirectory(root);
    }

    private static void scanDirectory(File directory) throws FileNotFoundException {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    if (file.getName().endsWith(".txt")) {  // Check if the file is a text file
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            System.out.println(line);  // Print the content of the file
                        }
                        scanner.close();
                    }
                } else if (file.isDirectory()) {
                    scanDirectory(file);  // Recursive call to scan the subdirectory
                }
            }
        }
    }
}