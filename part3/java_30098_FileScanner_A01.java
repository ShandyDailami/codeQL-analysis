import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_30098_FileScanner_A01 {
    public static void main(String[] args) {
        Path path = Paths.get(".");

        BasicFileAttributes attributes;
        try {
            attributes = Files.readAttributes(path, BasicFileAttributes.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        FileMode fileMode = attributes.isRegularFile() ? FileMode.READ : FileMode.NO_OP;
        FileVisitor fileVisitor = new SimpleFileVisitor<>(){
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println("Found file: " + file.toString());
                return FileVisitResult.CONTINUE;
            }
        };

        try {
            Files.walkFileTree(path, fileVisitor, FileVisitOption.FOLLOW_LINKS);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}