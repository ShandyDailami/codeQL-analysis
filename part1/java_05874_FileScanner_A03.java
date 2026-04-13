import java.io.*;
import java.util.*;

public class java_05874_FileScanner_A03 {
    public static void main(String[] args) throws IOException {
        // Specify the directory to scan
        File directory = new File("path/to/directory");

        // Use FileFilter to only scan .txt files
        FileFilter txtFilter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        };

        // Use FileVisitor to print file contents
        FileVisitor<Path> visitor = new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                // Print file name
                System.out.println("File: " + file.toFile().getName());

                // Read and print file contents
                try (BufferedReader reader = new BufferedReader(new FileReader(file.toFile()))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println("Line: " + line);
                    }
                }

                // Return CONTINUE to let other files visit
                return FileVisitResult.CONTINUE;
            }
        };

        // Use Files.walkFileTree to scan directory and print file contents
        Files.walkFileTree(directory.toPath(), visitor);
    }
}