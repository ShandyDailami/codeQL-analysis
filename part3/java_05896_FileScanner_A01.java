import java.nio.file.*;
import java.util.stream.*;

public class java_05896_FileScanner_A01 {

    public static void main(String[] args) {

        Path start = Paths.get("."); // Start directory

        try (Stream<Path> paths = Files.walk(start)) { // Use a Stream to iterate over the directory tree
            paths
                .filter(Files::isRegularFile) // Filter out directories
                .forEach(file -> { // For each file
                    try {
                        System.out.println("Scanning file: " + file.toString());
                        
                        // This is a placeholder for security-related operations.
                        // In a real-world application, you'd have a method to check if the file has a certain permission
                        // If the file does not have the necessary permission, you'd throw an exception here.
                        
                        // Checking for read permission
                        if(Files.readAttributes(file, StandardFileAttributes.class).contains(StandardFileAttributes.of(StandardFileAttributes.FileAttributes.permissions(), Files.getOwner(file), Sets.newHashSet()))) {
                            System.out.println("File is readable");
                        }
                        
                        // Checking for write permission
                        if(Files.readAttributes(file, StandardFileAttributes.class).contains(StandardFileAttributes.of(StandardFileAttributes.FileAttributes.permissions(), Files.getOwner(file), Sets.newHashSet(StandardFileAttributes.FileAttributes.writable())))) {
                            System.out.println("File is writable");
                        }

                        // Checking for execute permission
                        if(Files.readAttributes(file, StandardFileAttributes.class).contains(StandardFileAttributes.of(StandardFileAttributes.FileAttributes.permissions(), Files.getOwner(file), Sets.newHashSet(StandardFileAttributes.FileAttributes.executable())))) {
                            System.out.println("File is executable");
                        }
                        
                        System.out.println();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}