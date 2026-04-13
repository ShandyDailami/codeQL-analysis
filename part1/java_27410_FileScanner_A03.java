import java.io.*;
import java.nio.file.*;
import java.security.*;

public class java_27410_FileScanner_A03 {

    public static void main(String[] args) {
        try {
            Path path = Paths.get(".");
            Files.walkFileTree(path, new MyFileVisitor());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class MyFileVisitor extends SimpleFileVisitor<Path> {

        private static final MessageDigest MD = MessageDigest.getInstance("MD5");

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            String fileName = file.getFileName().toString();

            if (isSafeFile(fileName)) {
                System.out.println(fileName);
            }

            return FileVisitResult.CONTINUE;
        }

        private boolean isSafeFile(String fileName) {
            // You can add more checks here
            return true;
        }
    }
}