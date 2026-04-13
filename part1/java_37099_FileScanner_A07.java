import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_37099_FileScanner_A07 {

    private static final String DIRECTORY_TO_SCAN = "C:\\path\\to\\directory"; // Replace with the directory to scan

    public static void main(String[] args) throws IOException, SecurityException {
        Path path = Paths.get(DIRECTORY_TO_SCAN);

        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                FileVisitor.PollResult result = Files.probeContentType(file);
                if (result.isValid() && "application/x-java-bytecode".equals(result.getType())
                        && !file.getFileName().toString().endsWith(".class")) {
                    // Handle the file here. It's a Java bytecode file, it's not a .class file
                    System.out.println("Detected potentially dangerous Java bytecode file: " + file.toString());
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}