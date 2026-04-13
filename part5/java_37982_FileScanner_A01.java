import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_37982_FileScanner_A01 {
    public static void main(String[] args) {
        Path startingPath = Paths.get(".");

        // Use a try-with-resources statement to automatically close the directory stream
        try (DirectoryStream<Path> dirs = Files.newDirectoryStream(startingPath, "*")) {
            for (Path dir : dirs) {
                // Use try-with-resources statement to automatically close the file stream
                try (DirectoryStream<Path> files = Files.newDirectoryStream(dir, "*")) {
                    for (Path file : files) {
                        // This will only print out the name of the file
                        System.out.println(file.toString());

                        // Uncomment the following line to print out more details
                        // System.out.println("File: " + file.toAbsolutePath());
                        // System.out.println("Path: " + file.getFileName());
                        // System.out.println("Directory: " + dir.toAbsolutePath());
                        // System.out.println("Parent: " + dir.getParent().toString());
                        // System.out.println("Type: " + Files.getFileAttributeView(file, false));

                        // Uncomment the following line to check if file is readable
                        // if (Files.isReadable(file)) {
                        //     System.out.println("File is readable.");
                        // }

                        // Uncomment the following line to check if file is writable
                        // if (Files.isWritable(file)) {
                        //     System.out.println("File is writable.");
                        // }

                        // Uncomment the following line to check if directory is readable
                        // if (Files.isReadable(dir)) {
                        //     System.out.println("Directory is readable.");
                        // }

                        // Uncomment the following line to check if directory is writable
                        // if (Files.isWritable(dir)) {
                        //     System.out.println("Directory is writable.");
                        // }
                    }
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}