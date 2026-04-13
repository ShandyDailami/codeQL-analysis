import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class java_29120_FileScanner_A08 {
    private static final Set<String> SAFE_PATHS = new HashSet<>(Arrays.asList(
        "/dir1/", "/dir2/", "/dir3/", "/dir4/", "/dir5/", "/dir6/", "/dir7/", "/dir8/", "/dir9/", "/dir10/"));

    public static boolean isSafe(String path) {
        if (path == null || path.isEmpty()) {
            return false;
        }

        if (SAFE_PATHS.contains(path)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);
        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Invalid directory path");
            return;
        }

        File[] files = dir.listFiles();
        if (files == null) {
            System.out.println("Unable to list files in directory");
            return;
        }

        for (File file : files) {
            if (file.isFile() && !isSafe(file.getPath())) {
                System.out.println("Security-sensitive operation detected: " + file.getPath());
            }
        }
    }
}