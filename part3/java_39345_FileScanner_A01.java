import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class java_39345_FileScanner_A01 {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("Please specify a directory as the argument.");
            return;
        }

        File directory = new File(args[0]);

        if (!directory.exists()) {
            System.out.println("The specified directory does not exist.");
            return;
        }

        if (!directory.isDirectory()) {
            System.out.println("The specified path is not a directory.");
            return;
        }

        printDirectoryContents(directory);
    }

    private static void printDirectoryContents(File directory) throws IOException {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    printFileDetails(file);
                } else if (file.isDirectory()) {
                    System.out.println("Folder: " + file.getAbsolutePath());
                    printDirectoryContents(file);
                }
            }
        }
    }

    private static void printFileDetails(File file) throws IOException {
        BasicFileAttributes attrs = Files.readAttributes(Paths.get(file.getAbsolutePath()), BasicFileAttributes.class);

        System.out.println("File: " + file.getAbsolutePath());
        System.out.println("Size: " + attrs.size() + " bytes");
        System.out.println("Last modified: " + attrs.lastModifiedTime().toMillis() + " ms");
    }
}