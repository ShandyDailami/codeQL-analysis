import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Scanner;

public class java_22629_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // replace with your directory
        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        try {
                            long size = Files.size(Paths.get(file.getPath()));
                            System.out.println("File: " + file.getName());
                            System.out.println("Size: " + size);
                            System.out.println();
                        } catch (IOException e) {
                            System.out.println("Error reading file size: " + file.getName());
                            e.printStackTrace();
                        }
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist: " + directoryPath);
        }
    }
}