import java.io.File;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.io.IOException;

public class java_26177_FileScanner_A03 {
    public static void main(String[] args) {
        Path startPath = Path.of(".");

        copyFileOrDir(startPath, "target/");
    }

    private static void copyFileOrDir(Path startPath, String targetPath) {
        try {
            Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    File targetFile = new File(targetPath + file.toString());
                    if (!targetFile.getParentFile().exists()) {
                        targetFile.getParentFile().mkdirs();
                    }
                    Files.copy(file, targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    System.out.println(file.toString());
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    System.err.println(file + " visit failed: " + exc);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    if (exc != null) {
                        System.err.println(dir + " visit failed: " + exc);
                    } else {
                        System.out.println("Directory " + dir + " visited");
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}