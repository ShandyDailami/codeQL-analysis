import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class java_15184_FileScanner_A01 {
    private static final Set<String> BLOCKED_PATHS = new HashSet<>();

    static {
        BLOCKED_PATHS.add("src/blocked_path1");
        BLOCKED_PATHS.add("src/blocked_path2");
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a file path to scan:");
            String filePath = scanner.next();

            if (isBlockedPath(filePath)) {
                System.out.println("Access to " + filePath + " is blocked.");
            } else {
                System.out.println("Scanning " + filePath + "...");
                File file = new File(filePath);
                if (file.exists()) {
                    if (file.isDirectory()) {
                        printDirectoryContents(file);
                    } else {
                        System.out.println("File size: " + file.length() + " bytes");
                    }
                } else {
                    System.out.println("Path does not exist: " + filePath);
                }
            }
        }
    }

    private static boolean isBlockedPath(String path) {
        return BLOCKED_PATHS.contains(path);
    }

    private static void printDirectoryContents(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                } else {
                    System.out.println("Directory: " + file.getName());
                    printDirectoryContents(file);
                }
            }
        }
    }
}