import java.io.File;
import java.io.FilePermission;
import java.io.IOException;
import java.security.Permission;
import java.util.Scanner;

public class java_01951_FileScanner_A08 {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File file = new File(directoryPath);

        if (file.exists()) {
            if (file.isDirectory()) {
                System.out.println("Listing all files and directories in " + directoryPath);
                File[] files = file.listFiles();
                for (File f : files) {
                    if (f.canRead()) {
                        System.out.println(f.getAbsolutePath());
                    } else {
                        Permission permission = new FilePermission(f.getAbsolutePath(), "read");
                        throw new SecurityException("Permission denied: " + permission);
                    }
                }
            } else {
                System.out.println(directoryPath + " is not a directory.");
            }
        } else {
            System.out.println(directoryPath + " does not exist.");
        }
    }
}