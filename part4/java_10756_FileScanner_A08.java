import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class java_10756_FileScanner_A08 {
    public static void main(String[] args) throws IOException {
        String dirPath = "path/to/directory"; // replace with your directory path
        File dir = new File(dirPath);
        scanDirectory(dir);
    }

    public static void scanDirectory(File dir) throws IOException {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanDirectory(file);
                } else {
                    processFile(file);
                }
            }
        }
    }

    public static void processFile(File file) throws IOException {
        // Add your security-sensitive operations here, e.g., checking file integrity
        // If the file is not valid, throw an exception

        // Read file content
        FileInputStream fis = new FileInputStream(file);
        byte[] data = new byte[(int) file.length()];
        fis.read(data);
        fis.close();

        // Do something with the file content, e.g., print the file size
        System.out.println("File name: " + file.getName());
        System.out.println("File size: " + file.length() + " bytes");
    }
}