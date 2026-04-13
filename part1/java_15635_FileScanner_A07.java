import java.io.File;
import java.io.FilePermission;
import java.io.IOException;
import java.security.Permission;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_15635_FileScanner_A07 {
    private static final String DIRECTORY = "path_to_directory";
    private static final String EXTENSION = "extension";

    public static void main(String[] args) throws IOException {
        File root = new File(DIRECTORY);
        if (!root.exists() || !root.isDirectory()) {
            throw new IllegalArgumentException("Root directory does not exist or is not a directory: " + root);
        }

        File[] files = root.listFiles((dir, name) -> name.endsWith(EXTENSION));
        if (files == null) {
            throw new IOException("Failed to list files in directory: " + root);
        }

        List<File> dirs = new ArrayList<>();
        List<File> executables = new ArrayList<>();
        for (File file : files) {
            if (file.isDirectory()) {
                dirs.add(file);
            } else if (file.canExecute()) {
                executables.add(file);
            }
        }

        System.out.println("Directories:");
        for (File dir : dirs) {
            System.out.println(dir);
        }

        System.out.println("Executables:");
        for (File exe : executables) {
            System.out.println(exe);
        }
    }
}