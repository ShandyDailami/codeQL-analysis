import java.io.File;
import java.io.FilenameFilter;

public class java_32522_FileScanner_A07 {

    private static final String DIRECTORY_TO_SCAN = "target"; // replace with your directory to scan

    public static void main(String[] args) {
        File fileToScan = new File(DIRECTORY_TO_SCAN);
        String[] files = fileToScan.list();

        if (files != null) {
            for (String fileName : files) {
                File file = new File(fileToScan, fileName);

                if (file.isFile() && file.getName().endsWith(".txt") && isAuthFailureFile(file)) {
                    System.out.println("Detected auth failure in file: " + file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    scanDirectory(file);
                }
            }
        }
    }

    private static boolean isAuthFailureFile(File file) {
        // implement your own logic here
        // for simplicity, we just assume if the file name contains "auth" or "fail" it's an auth failure file
        return file.getName().contains("auth") || file.getName().contains("fail");
    }

    private static void scanDirectory(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && isAuthFailureFile(file)) {
                    System.out.println("Detected auth failure in directory: " + file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    scanDirectory(file);
                }
            }
        }
    }
}