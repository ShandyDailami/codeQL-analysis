import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_35778_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File directory = new File(path);

        if (directory.exists()) {
            File[] files = directory.listFiles(new FileFilter() {
                public boolean accept(File pathname) {
                    return pathname.isFile() && pathname.getName().endsWith(".txt");
                }
            });

            if (files != null) {
                Arrays.stream(files).forEach(file -> System.out.println(file.getAbsolutePath()));
            } else {
                System.out.println("No .txt files found in the directory.");
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }
}