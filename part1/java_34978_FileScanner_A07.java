import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilePermission;
import java.io.IOException;
import java.security.Permission;

public class java_34978_FileScanner_A07 {
    public static void main(String[] args) {
        String dirPath = "/path/to/directory";  // replace with your directory path
        String filePattern = ".*.txt";  // replace with your file pattern

        SecurityManager sm = new SecurityManager() {
            @Override
            public void checkPermission(Permission perm) {
                if (perm instanceof FilePermission) {
                    File file = new File(dirPath, "nonExistentFile");
                    try {
                        file.createNewFile();
                        System.out.println("File created with name: " + file.getName());
                    } catch (IOException e) {
                        System.out.println("Failed to create file for permission check");
                    }
                }
            }
        };

        File dir = new File(dirPath);
        File[] files = dir.listFiles((dir, name) -> name.matches(filePattern));

        if (files != null) {
            for (File file : files) {
                try {
                    sm.checkPermission(new FilePermission(file.getPath(), "read"));
                    System.out.println("File with name: " + file.getName() + " has permission to read");
                } catch (SecurityException se) {
                    System.out.println(se.getMessage());
                }
            }
        }
    }
}