import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_31492_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "path/to/directory"; // replace with your directory path
        File directory = new File(directoryPath);

        // use recursive method to process all files in the directory
        processDirectory(directory);
    }

    private static void processDirectory(File directory) {
        if (directory.listFiles() == null) {
            // if directory is empty, return
            return;
        }

        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                // process file
                try {
                    processFile(file);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            } else if (file.isDirectory()) {
                // process directory
                processDirectory(file);
            }
        }
    }

    private static void processFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            // process line (e.g., print it)
            System.out.println(line);
        }
        scanner.close();
    }
}