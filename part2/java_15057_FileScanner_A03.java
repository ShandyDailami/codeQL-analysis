import java.io.File;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardVisitResult;
import java.nio.file.attribute.BasicFileAttributes;

public class java_15057_FileScanner_A03 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        FileVisitResult visitDirectoryResult = visitDirectory(new File(directoryPath));

        if (visitDirectoryResult == FileVisitResult.TERMINATED) {
            System.out.println("Directory traversal was terminated");
        }
    }

    public static FileVisitResult visitDirectory(File directory) {
        FileVisitResult result = null;

        if (directory.canRead()) {
            System.out.println("Directory: " + directory.getAbsolutePath());
            SimpleFileVisitor<Path> simpleFileVisitor = new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                    System.out.println("File: " + file.toString());
                    // add your logic to handle files here

                    // For example, if you want to scan files in the directory
                    // if (file.toString().endsWith(".txt")) {
                    //     System.out.println("Found txt file: " + file.toString());
                    // }

                    return super.visitFile(file, attrs);
                }
            };
            result = simpleFileVisitor.visitDirectory(directory.toPath());
        } else {
            System.out.println("Cannot read directory: " + directory.getAbsolutePath());
        }

        return result;
    }
}