import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_08279_FileScanner_A07 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        try (Scanner scanner = new Scanner(file)) {
                            while (scanner.hasNextLine()) {
                                String line = scanner.nextLine();
                                // process each line (e.g., print or ignore)
                                System.out.println(line);
                            }
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    } else if (file.isDirectory()) {
                        // recursively scan subdirectories
                        scanDirectory(file);
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }

    private static void scanDirectory(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    try (Scanner scanner = new Scanner(file)) {
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            // process each line (e.g., print or ignore)
                            System.out.println(line);
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                } else if (file.isDirectory()) {
                    // recursively scan subdirectories
                    scanDirectory(file);
                }
            }
        }
    }
}