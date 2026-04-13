import java.io.File;
import java.io.FilePermission;
import java.io.IOException;

public class java_09377_FileScanner_A01 {
    public static void main(String[] args) {
        File directory = new File(".");
        printFiles(directory);
    }

    public static void printFiles(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                    try {
                        FilePermission fp = new FilePermission.Group(file.getOwner(), "read");
                        if (file.setReadable(true, fp)) {
                            System.out.println("File " + file.getName() + " is readable.");
                        } else {
                            System.out.println("File " + file.getName() + " is NOT readable.");
                        }
                    } catch (IOException e) {
                        System.out.println("Error checking permissions: " + e.getMessage());
                    }
                }
            }
        }
    }
}