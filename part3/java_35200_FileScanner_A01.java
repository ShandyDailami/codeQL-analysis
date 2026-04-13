import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_35200_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        FileScanner scanner = new FileScanner();
        scanner.scanDirectory("C:/path/to/directory"); // replace with your directory
    }
}

class FileScanner {
    public void scanDirectory(String directoryPath) throws FileNotFoundException {
        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            for (File file : files) {
                if (file.isFile()) {
                    printFileContents(file);
                } else if (file.isDirectory()) {
                    scanDirectory(file.getPath());
                }
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }

    private void printFileContents(File file) throws FileNotFoundException {
        if (file.canRead()) {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    System.out.println(scanner.nextLine());
                }
            }
        } else {
            System.out.println("Cannot read file: " + file.getPath());
        }
    }
}