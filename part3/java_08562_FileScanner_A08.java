import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class java_08562_FileScanner_A08 {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide a directory path as an argument.");
            System.exit(1);
        }

        String directoryPath = args[0];
        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("The provided path does not exist or is not a directory.");
            System.exit(1);
        }

        try {
            Files.walkFileTree(directory.toPath(), new FileVisitor());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class FileVisitor extends SimpleFileVisitor<Path> {

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (file.toFile().isFile() && !file.toFile().canRead()) {
                System.out.println("Security warning: file " + file.toAbsolutePath() + " is not readable.");
            }
            return FileVisitResult.CONTINUE;
        }
    }
}