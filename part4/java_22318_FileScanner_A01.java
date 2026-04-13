import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_22318_FileScanner_A01 {
    public static void main(String[] args) {
        FileScanner scanner = new FileScanner();
        scanner.scanDirectory(".", false);
    }
}

class FileScanner {
    public void scanDirectory(String directory, boolean recursive) {
        File rootDirectory = new File(directory);
        File[] directoryContents = rootDirectory.listFiles();

        if (directoryContents == null) {
            return;
        }

        for (File file : directoryContents) {
            if (file.isDirectory() && recursive) {
                scanDirectory(file.getPath(), true);
            } else if (!file.isDirectory()) {
                handleFile(file);
            }
        }
    }

    public void handleFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Perform security-sensitive operation here
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}