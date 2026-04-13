import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class java_33851_FileScanner_A07 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        FileVisitResult result = visitDirectory(new File(directoryPath));

        if (result == FileVisitResult.TERMINATED) {
            System.out.println("File visit interrupted");
        } else {
            System.out.println("File visit completed");
        }
    }

    private static FileVisitResult visitDirectory(File directory) {
        try {
            Files.walkFileTree(directory.toPath(), new MyFileVisitor());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return FileVisitResult.CONTINUE;
    }

    private static class MyFileVisitor extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            // print file name
            System.out.println("File: " + file.toString());

            // print the file content
            if (Files.size(file) > 0) {
                System.out.println("Content: " + Files.readAllLines(file).toString());
            }

            return FileVisitResult.CONTINUE;
        }
    }
}