import java.io.File;
import java.io.FileFilter;
import java.io.FileVisitor;
import java.io.IOException;

public class java_33032_FileScanner_A07 implements FileVisitor<Path> {
    private String extension;

    public java_33032_FileScanner_A07(String extension) {
        this.extension = extension;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (file.toString().endsWith(extension)) {
            System.out.println("File found: " + file);
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.err.println("Visit file failed: " + file);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: FileScanner <extension>");
            System.exit(1);
        }

        String extension = args[0];
        FileScanner scanner = new FileScanner(extension);
        File startDirectory = new File(".");

        if (startDirectory.isDirectory()) {
            try {
                Files.walkFileTree(startDirectory.toPath(), scanner);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("Not a directory");
        }
    }
}