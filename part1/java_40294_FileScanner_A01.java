import java.io.File;
import java.util.Scanner;

public class java_40294_FileScanner_A01 {

    private static final String HIDDEN_FILES_PREFIX = ".";
    private static final String DIRECTORY_PATH = ".";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your password:");
        String password = scanner.nextLine();
        scanner.close();

        if ("PASSWORD".equals(password)) {
            listFiles(new File(DIRECTORY_PATH), true);
        } else {
            System.out.println("Access denied!");
        }
    }

    private static void listFiles(File directory, boolean showHidden) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    if (showHidden || !file.isHidden()) {
                        listFiles(file, showHidden);
                    }
                } else if (!file.getName().startsWith(HIDDEN_FILES_PREFIX)) {
                    checkFileAccess(file);
                }
            }
        }
    }

    private static void checkFileAccess(File file) {
        try {
            if (file.getCanonicalPath().startsWith(DIRECTORY_PATH)) {
                throw new SecurityException("Access violation: " + file.getCanonicalPath());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}