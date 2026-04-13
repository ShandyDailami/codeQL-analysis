import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

public class java_11944_FileScanner_A03 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the directory: ");
            String directoryPath = scanner.next();

            File dir = new File(directoryPath);
            if (!dir.exists()) {
                System.out.println("Directory does not exist!");
                return;
            }

            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        processFile(file);
                    } else if (file.isDirectory()) {
                        processDirectory(file);
                    }
                }
            } else {
                processDirectory(dir);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void processFile(File file) {
        try (FileReader reader = new FileReader(file);
             PrintWriter writer = new PrintWriter(new FileWriter(file, true))) {
            System.out.println("Processing file: " + file.getName());
            String line;
            while ((line = reader.readLine()) != null) {
                writer.println(line);
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processDirectory(File dir) {
        try {
            Path path = Paths.get(dir.getPath());
            BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
            System.out.println("Directory: " + dir.getPath());
            System.out.println("Creation Time: " + attributes.creationTime());
            System.out.println("Last Modified Time: " + attributes.lastModifiedTime());
            System.out.println("Readable: " + attributes.isReadable());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}