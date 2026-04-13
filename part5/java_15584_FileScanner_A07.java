import java.io.File;
import java.util.Scanner;

public class java_15584_FileScanner_A07 {

    public static void main(String[] args) {
        File directory = new File(".");
        printFilesInDirectory(directory);
    }

    private static void printFilesInDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && isSecuritySensitiveOperation(file)) {
                    System.out.println(file.getName());
                } else if (file.isDirectory()) {
                    printFilesInDirectory(file);
                }
            }
        }
    }

    private static boolean isSecuritySensitiveOperation(File file) {
        // TODO: Implement your logic here
        return false;
    }
}