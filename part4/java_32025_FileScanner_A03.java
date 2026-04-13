import java.io.File;
import java.io.FilePermission;
import java.security.Permission;
import java.util.ArrayList;
import java.util.List;

public class java_32025_FileScanner_A03 {
    public static void main(String[] args) {
        // Set the directory to scan
        File directory = new File(".");

        // Use File's list method to get a list of all files in the directory
        File[] files = directory.listFiles();

        // Use a loop to print out the names of all files in the directory
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                }
            }
        }

        // Set the permissions for the current directory
        List<Permission> perms = new ArrayList<>();
        perms.add(new FilePermission(".", "read"));
        try {
            // Try to set the permissions for the current directory
            FilePermission.2delete(directory, perms);
        } catch (UnsupportedOperationException e) {
            System.out.println("Setting file permissions is not supported.");
        }
    }
}