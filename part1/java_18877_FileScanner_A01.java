import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class java_18877_FileScanner_A01 {

    public static void main(String[] args) throws IOException {
        File rootDir = new File("."); // This will point to the current directory
        scanDirectory(rootDir);
    }

    private static void scanDirectory(File dir) throws IOException {
        if (dir.listFiles() == null) { // This will return null if the directory is empty
            return;
        }

        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                scanDirectory(file);
            } else if (file.isFile()) {
                printFileInfo(file);
            }
        }
    }

    private static void printFileInfo(File file) {
        System.out.println("File: " + file.getAbsolutePath());
        // You can add more file information if needed. For example, you can print the size of the file
        // System.out.println("Size: " + file.length());
    }
}