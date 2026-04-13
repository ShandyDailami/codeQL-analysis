import java.io.File;
import java.security.Permission;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_21525_FileScanner_A01 {
    private static List<File> dirs = new ArrayList<>();
    private static List<File> files = new ArrayList<>();

    public static void main(String[] args) {
        String directory = args.length > 0 ? args[0] : System.getProperty("java.class.path");

        // Add directories to scan.
        addDirectoryToScan(new File(directory));

        // Start scanning.
        scan();
    }

    private static void addDirectoryToScan(File dir) {
        if (dir.isDirectory()) {
            dirs.add(dir);
        } else {
            files.add(dir);
        }

        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                addDirectoryToScan(file);
            } else {
                files.add(file);
            }
        }
    }

    private static void scan() {
        for (File file : files) {
            checkFilePermissions(file);
        }

        for (File dir : dirs) {
            checkDirectoryPermissions(dir);
        }
    }

    private static void checkFilePermissions(File file) {
        try {
            // Try to access the file.
            FileReader reader = new FileReader(file);
            // If we can't access the file, the user may not have permission.
            reader.read();
            System.out.println("File at " + file.getAbsolutePath() + " can be read.");
        } catch (Exception e) {
            // If we can't access the file, the user may not have permission.
            System.out.println("File at " + file.getAbsolutePath() + " cannot be read.");
        }
    }

    private static void checkDirectoryPermissions(File dir) {
        try {
            // Try to access the directory.
            FileReader reader = new FileReader(dir);
            // If we can't access the directory, the user may not have permission.
            reader.read();
            System.out.println("Directory at " + dir.getAbsolutePath() + " can be read.");
        } catch (Exception e) {
            // If we can't access the directory, the user may not have permission.
            System.out.println("Directory at " + dir.getAbsolutePath() + " cannot be read.");
        }
    }
}