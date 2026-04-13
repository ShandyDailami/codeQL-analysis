import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_17222_FileScanner_A03 {

    private static final String DIR = "C:\\temp";
    private static final String SECURITY_PREFIX = "SEC";

    public static void main(String[] args) {
        File dir = new File(DIR);
        if (dir.exists()) {
            File[] files = dir.listFiles();
            if (files != null) {
                Arrays.stream(files).forEach(file -> {
                    if (file.isFile()) {
                        printFileInfo(file);
                    } else {
                        printDirectoryInfo(file);
                    }
                });
            } else {
                System.out.println("No files found in directory.");
            }
        } else {
            System.out.println("Directory not found.");
        }
    }

    private static void printDirectoryInfo(File dir) {
        String prefix = dir.getName().startsWith(SECURITY_PREFIX) ? "[" + dir.getName() + "]" : dir.getName();
        System.out.println(prefix + " - " + dir.getAbsolutePath());
    }

    private static void printFileInfo(File file) {
        if (file.getName().startsWith(SECURITY_PREFIX)) {
            System.out.println(file.getName() + " - " + file.getAbsolutePath());
        }
    }
}