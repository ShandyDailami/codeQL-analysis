import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class java_20551_FileScanner_A07 {

    private static final Set<String> SAFE_PATHS = new HashSet<>();

    static {
        SAFE_PATHS.add("src/main/resources/safe");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && isAuthFailure(file)) {
                    System.out.println("File: " + file.getAbsolutePath() + " has auth failure");
                } else if (file.isDirectory()) {
                    scanDirectory(file);
                }
            }
        }
    }

    private static void scanDirectory(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && isAuthFailure(file)) {
                    System.out.println("Directory: " + file.getAbsolutePath() + " has auth failure");
                } else if (file.isDirectory()) {
                    scanDirectory(file);
                }
            }
        }
    }

    private static boolean isAuthFailure(File file) {
        if (file.getAbsolutePath().contains(SAFE_PATHS)) {
            return false;
        }

        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("authFailure")) {
                    return true;
                }
            }
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        return false;
    }
}