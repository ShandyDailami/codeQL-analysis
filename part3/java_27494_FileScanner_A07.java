import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_27494_FileScanner_A07 {
    private static final String HIDDEN_FILES = ".*\\.?(bat|exe|dll|com|hqx|jar|jspx|lib|mdb|sav|sdb|so|swp|tmp|ppt|doc|xls|pdf|txt|sql|md)$";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.next();
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist!");
            return;
        }

        printHiddenFiles(directory, new StringBuilder());
    }

    private static void printHiddenFiles(File directory, StringBuilder sb) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    printHiddenFiles(file, sb);
                } else {
                    if (isHiddenFile(file.getName()) && !isHiddenFile(file.getAbsolutePath())) {
                        sb.append(file.getAbsolutePath()).append(System.lineSeparator());
                    }
                }
            }
        }

        System.out.println(sb.toString());
    }

    private static boolean isHiddenFile(String fileName) {
        return fileName.matches(HIDDEN_FILES);
    }
}