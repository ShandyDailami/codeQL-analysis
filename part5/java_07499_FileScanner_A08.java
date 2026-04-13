import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_07499_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // Replace with your directory path
        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("The specified directory does not exist or is not a directory.");
            return;
        }

        File[] files = directory.listFiles();

        if (files == null) {
            System.out.println("Could not list files in the directory.");
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                Scanner scanner = null;
                try {
                    scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        // TODO: Add code to check for integrity failures here
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } finally {
                    if (scanner != null) {
                        scanner.close();
                    }
                }
            }
        }
    }
}