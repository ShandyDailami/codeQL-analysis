import java.io.*;
import java.nio.file.*;
import java.security.Permission;
import java.security.PermissionCollection;

public class java_04021_FileScanner_A01 {

    private static final PermissionCollection PERMISSIONS = new PermissionCollection() {
        @Override
        public void addPermissions(PermissionCollection target) {
            super.addPermissions(target);
            target.add(new Permission("read"));
            target.add(new Permission("write"));
            target.add(new Permission("delete"));
        }
    };

    private static final PathMatcher PATTERN = FileSystems.getDefault().getPathMatcher("glob:*.txt");

    public static void main(String... args) throws IOException, SecurityException {
        FileSystem fs = FileSystems.newFileSystem(Paths.get("/path/to/your/dir"), PERMISSIONS);
        try (DirectoryStream<Path> dirs = fs.newDirectoryStream(Paths.get("/path/to/your/dir"))) {
            for (Path p : dirs) {
                if (PATTERN.matches(p.getFileName())) {
                    try (Stream<String> lines = Files.lines(p)) {
                        lines.forEach(line -> {
                            // Perform security sensitive operations here.
                            // For example, printing the line to the console.
                            System.out.println(line);
                        });
                    }
                }
            }
        }
    }
}