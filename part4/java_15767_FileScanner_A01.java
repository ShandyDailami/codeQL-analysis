import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.UserPrincipal;

public class java_15767_FileScanner_A01 {
    public static void main(String[] args) {
        try {
            // Create a new file and set its permission
            Path path = Paths.get("testfile.txt");
            Files.setPosixFilePermissions(path, Files.readLinkOptions.REPLACE_EXISTING,
                    Files.setPosixFilePermissions(path, FilePermission.of("read", UserPrincipal.of("user", "group"), "write")));

            // Check the permissions
            FilePermission[] perms = Files.getPosixFilePermissions(path);
            System.out.println("Permissions: " + perms[0].toString());

            // Try to access the file
            File file = new File(path.toString());
            if (file.canRead()) {
                System.out.println("File can be read");
            } else {
                System.out.println("File cannot be read");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}