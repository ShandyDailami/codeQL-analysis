import java.io.*;
import java.util.*;

public class java_25933_FileScanner_A03 {
    public static void main(String[] args) {
        File file = new File(".");

        try (FileScanner scanner = new FileScanner(file)) {
            while (scanner.hasNext()) {
                Path filePath = scanner.nextPath();
                String fileName = filePath.toString();
                System.out.println(fileName);
           
                // You can add your security-sensitive operations here like:
                // fileName = sanitizeFileName(fileName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String sanitizeFileName(String fileName) {
        // Replace '..' with ''
        fileName = fileName.replace("..", "");

        // Replace '/' with '\'
        fileName = fileName.replace("/", "\\");

        // Remove any '.' characters
        fileName = fileName.replace(".", "");

        // Remove '.' from the end of the filename
        fileName = fileName.replaceFirst("\\.$", "");

        // Replace '?' with ''
        fileName = fileName.replace("?", "");

        return fileName;
    }
}