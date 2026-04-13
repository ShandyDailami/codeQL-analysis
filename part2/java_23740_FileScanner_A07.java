import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_23740_FileScanner_A07 {
    public static void main(String[] args) {
        String directory = "/path/to/directory"; // Provide your directory path here
        FileScanner scanner = new FileScanner(directory);
        scanner.scanFiles(true);
    }
}

class FileScanner {
    private String directory;

    public java_23740_FileScanner_A07(String directory) {
        this.directory = directory;
    }

    public void scanFiles(boolean recursive) {
        File file = new File(directory);

        if (!file.exists()) {
            System.out.println("Directory does not exist.");
            return;
        }

        if (file.isDirectory()) {
            scanDirectory(file, recursive);
        } else {
            System.out.println("Input is not a directory.");
        }
    }

    private void scanDirectory(File file, boolean recursive) {
        File[] files = file.listFiles();

        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    if (recursive) {
                        scanDirectory(f, recursive);
                    }
                } else {
                    scanFile(f);
                }
            }
        }
    }

    private void scanFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            System.out.println("Scanning file: " + file.getAbsolutePath());

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getAbsolutePath());
        }
    }
}