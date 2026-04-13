import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class java_08325_FileScanner_A01 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        scanDirectory(directoryPath);
    }

    public static void scanDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    printFileDetails(file);
                } else if (file.isDirectory()) {
                    scanDirectory(file.getPath());
                }
            }
        }
    }

    public static void printFileDetails(File file) {
        try {
            Path path = Paths.get(file.getPath());
            BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
            System.out.println("File Name: " + file.getName());
            System.out.println("File Path: " + file.getPath());
            System.out.println("File Size: " + attributes.size() + " bytes");
            System.out.println("File Last Modified: " + attributes.lastModifiedTime().toMillis() + " milliseconds");
            System.out.println("-----------------");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}