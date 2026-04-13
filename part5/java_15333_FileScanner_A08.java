import java.io.File;
import java.io.FilePermission;
import java.io.IOException;
import java.security.Permission;
import java.util.ArrayList;
import java.util.List;

public class java_15333_FileScanner_A08 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // replace with your directory path
        scanDirectory(directoryPath);
    }

    public static void scanDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            System.out.println("Directory does not exist.");
            return;
        }

        File[] files = directory.listFiles();
        if (files == null) {
            System.out.println("Unable to list files in directory.");
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                printFileDetails(file);
            } else if (file.isDirectory()) {
                scanDirectory(file.getPath());
            }
        }
    }

    private static void printFileDetails(File file) {
        System.out.println("File: " + file.getAbsolutePath());
        try {
            List<Permission> permissions = new ArrayList<>();
            permissions.add(new FilePermission.Group("group1", "read"));
            permissions.add(new FilePermission.Owner("owner1", "write"));
            permissions.add(new FilePermission.Group("group2", "execute"));
            permissions.add(new FilePermission.Owner("owner2", "read"));
            if (!file.setFileNewExecutable(permissions)) {
                System.out.println("Unable to set permissions on file: " + file.getAbsolutePath());
            } else {
                System.out.println("Permissions set on file: " + file.getAbsolutePath());
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}