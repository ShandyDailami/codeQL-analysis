import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_09958_FileScanner_A07 {
    private PathMatcher<Path> matcher = FileSystems.getDefault().getPathMatcher("glob:**/*.txt");

    public void scan(Path dir) throws Exception {
        if (Files.notExists(dir)) {
            throw new Exception("Directory does not exist: " + dir);
        }

        Files.walkFileTree(dir, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (matcher.matches(file.getFileName())) {
                    System.out.println("Found file: " + file.toString());
                    // Here you can add code to handle security-related operations
                    // For instance, checking file permissions and security context
                    // You can use Java security library for that, but it's not allowed to use external frameworks

                    // Here is a simple example of checking file permissions
                    if (Files.isReadable(file)) {
                        System.out.println("File is readable: " + file.toString());
                    }

                    // Here is a simple example of checking user authentication
                    // You can use Java security library for that, but it's not allowed to use external frameworks
                    if (SecurityContext.getCurrentSecurityContext().getAuthentication().getPrincipal().equals("user")) {
                        System.out.println("User is authenticated: " + file.toString());
                    }
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}