import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;

import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_20646_FileScanner_A03 {

    public static void main(String[] args) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.java");

        try (PrintWriter pw = new PrintWriter("results.txt")) {
            Files.walkFileTree(Paths.get("."), new MyFileVisitor(matcher, pw));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class MyFileVisitor extends SimpleFileVisitor<Path> {
        private final PathMatcher matcher;
        private final PrintWriter pw;

        MyFileVisitor(PathMatcher matcher, PrintWriter pw) {
            this.matcher = matcher;
            this.pw = pw;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (matcher.matches(file.getFileName())) {
                // We only care about .java files
                // Check for injection attacks
                if (file.toString().contains("password") || file.toString().contains("username")
                        || file.toString().contains("dbpassword") || file.toString().contains("dbuser")) {
                    pw.println("Suspicious file: " + file.toString());
                }
            }
            return FileVisitResult.CONTINUE;
        }
    }
}