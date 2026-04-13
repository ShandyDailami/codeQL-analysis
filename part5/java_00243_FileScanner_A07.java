import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class java_00243_FileScanner_A07 {
    public static void main(String[] args) throws IOException {
        File rootDirectory = new File("./");
        List<File> filesWithAuthFailures = Files.find(rootDirectory.toPath(), Integer.MAX_VALUE,
                (path, attrs) -> Files.isRegularFile(path) && Files.readAttributes(path, attrs)
                        .equals(Files.readAttributes(path, attrs)) && Files.isReadable(path))
                .map(Path::toFile).collect(Collectors.toList());

        filesWithAuthFailures.forEach(file -> {
            try {
                Files.write(file.toPath(), "AuthFailure detected in " + file.getPath() + "\n".getBytes(),
                        StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    static class AuthFailureFileVisitor extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (Files.readAttributes(file.toFile().toPath(), attrs)
                    .equals(Files.readAttributes(file.toFile().toPath(), attrs))) {
                return FileVisitResult.CONTINUE;
            }

            Files.write(file, ("AuthFailure detected in " + file.toString() + "\n").getBytes(),
                    StandardOpenOption.APPEND);
            return FileVisitResult.TERMINATE;
        }
    }
}