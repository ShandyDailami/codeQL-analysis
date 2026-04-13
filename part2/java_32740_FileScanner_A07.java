import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_32740_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String path = scanner.next();
        scanner.close();

        File file = new File(path);

        printFiles(file, "");
    }

    private static void printFiles(File file, String path) {
        File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        });

        if (files != null) {
            for (File f : files) {
                System.out.println(path + "/" + f.getName());
                printFiles(f, path + "/" + f.getName());
            }
        }
    }
}