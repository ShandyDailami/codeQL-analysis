import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_20849_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        String directory = "."; // Current directory
        File file = new File(directory);

        // Ensure the directory exists and is accessible
        if (!file.exists()) {
            throw new IllegalArgumentException("Directory does not exist: " + directory);
        }

        if (file.isDirectory()) {
            for (File item : file.listFiles()) {
                if (item.isFile() && item.getName().endsWith(".txt")) {
                    printFileInfo(item);
                }
            }
        }
    }

    private static void printFileInfo(File file) {
        // Get file permissions
        String permissions = String.valueOf(file.getPermission());
        System.out.println("File: " + file.getName());
        System.out.println("Permissions: " + permissions);

        // Get file owner and group
        File owner = new File(file.getParent());
        File group = new File(file.getParent());
        System.out.println("Owner: " + owner.getName() + " (" + owner.getAbsolutePath() + ")");
        System.out.println("Group: " + group.getName() + " (" + group.getAbsolutePath() + ")");
    }
}