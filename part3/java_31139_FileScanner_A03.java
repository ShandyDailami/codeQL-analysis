import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_31139_FileScanner_A03 {
    public static void main(String[] args) {
        // Create a FileScanner instance.
        FileScanner scanner = new FileScanner();

        // Use the scanner to start scanning a directory.
        scanner.startScanning("./src/main/java");
    }
}

class FileScanner {
    private File[] files;
    private int currentFileIndex;

    public void startScanning(String directory) {
        File file = new File(directory);
        if (file.exists() && file.isDirectory()) {
            FileFilter filter = (File pathname) -> {
                String name = pathname.getName();
                return name.endsWith(".java");
            };
            files = file.listFiles(filter);
            currentFileIndex = -1;
            nextFile();
        } else {
            System.out.println("Invalid directory: " + directory);
        }
    }

    private void nextFile() {
        if (currentFileIndex < files.length - 1) {
            currentFileIndex++;
            printFileInfo(files[currentFileIndex]);
            nextFile();
        }
    }

    private void printFileInfo(File file) {
        try {
            Scanner scanner = new Scanner(file.toPath());
            while (scanner.hasNextLine()) {
                System.out.println("File: " + file.getPath());
                System.out.println("Line: " + scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file: " + file.getPath());
        }
    }
}