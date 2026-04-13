import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.security.Permission;
import java.util.Scanner;

public class java_12587_FileScanner_A08 {

    public static void main(String[] args) {
        FileSystemPermission permission = new FileSystemPermission.GroupPermission("file.*", "read,write");
        FileSystemPermission[] noPermission = new FileSystemPermission[0];

        File file = new File("C:/Users/your_directory_here");

        try {
            if (file.setFilePermission(permission, noPermission)) {
                scanDirectory(file);
            } else {
                System.out.println("Unable to set permissions");
            }
        } catch (SecurityException e) {
            System.out.println("Caught a SecurityException: " + e.getMessage());
        }
    }

    private static void scanDirectory(File dir) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanDirectory(file);
                } else if (file.isFile()) {
                    scanFile(file);
                }
            }
        }
    }

    private static void scanFile(File file) {
        try (Scanner scanner = new Scanner(new FileReader(file))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getPath());
        }
    }
}