import java.io.File;
import java.security.Permission;
import java.security.SecurityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_41275_FileScanner_A08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);
        if (!dir.exists()) {
            System.out.println("Invalid directory");
            return;
        }

        List<File> files = new ArrayList<>();
        findFilesWithIntegrityFailure(dir, files);

        if (files.isEmpty()) {
            System.out.println("No files with integrity failure found in the directory");
        } else {
            System.out.println("Files with integrity failure:");
            for (File file : files) {
                System.out.println(file.getAbsolutePath());
            }
        }
    }

    private static void findFilesWithIntegrityFailure(File dir, List<File> files) {
        File[] filesInDir = dir.listFiles();
        if (filesInDir != null) {
            for (File file : filesInDir) {
                if (file.isDirectory()) {
                    findFilesWithIntegrityFailure(file, files);
                } else {
                    try {
                        SecurityManager sm = System.getSecurityManager();
                        if (sm != null) {
                            Permission p = sm.getPermission(file);
                            if (p != null) {
                                files.add(file);
                            }
                        } else {
                            files.add(file);
                        }
                    } catch (SecurityException se) {
                        // Handle exception
                    }
                }
            }
        }
    }
}