import java.io.*;
import java.nio.file.*;
import java.util.*;

public class java_01984_FileScanner_A07 {
    public static void main(String[] args) {
        try {
            Path path = Paths.get(".");
            Files.walkFileTree(path, new MyFileVisitor());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class MyFileVisitor extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
            FileVisitResult result = super.visitFile(file, attrs);
            if (file.toString().endsWith(".java")) {
                try {
                    processJavaFile(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return result;
        }

        private void processJavaFile(Path file) throws IOException {
            Scanner scanner = new Scanner(file.toFile());
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("A07_AuthFailure")) {
                    // Here is the security-sensitive operation related to A07_AuthFailure
                    // For example, we print the line number and the line content:
                    System.out.println("File: " + file.getFileName());
                    System.out.println("Line Number: " + (scanner.getLineNumber()));
                    System.out.println("Line Content: " + line);
                }
            }
            scanner.close();
        }
    }
}