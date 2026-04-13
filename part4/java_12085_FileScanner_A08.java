import java.nio.file.*;
import java.nio.file.attribute.*;
import java.security.*;

public class java_12085_FileScanner_A08 {

    public static void main(String[] args) throws Exception {
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkAccess(new FileAttributeView(Paths.get("."), FileAttributes.class));
        }

        Path dir = Paths.get(".");
        try (DirectoryStream<Path> ds = Files.newDirectoryStream(dir, "*.txt")) {
            for (Path p : ds) {
                BasicFileAttributes attrs = Files.readAttributes(p, BasicFileAttributes.class);
                System.out.println(p + " is " + (attrs.isRegularFile() ? "regular" : "directory"));
            }
        }
    }
}