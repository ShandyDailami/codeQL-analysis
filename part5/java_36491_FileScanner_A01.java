import java.io.File;
import java.io.FileFilter;
import java.util.Scanner;

public class java_36491_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String dirPath = scanner.nextLine();
        File dir = new File(dirPath);

        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Invalid directory!");
            System.exit(0);
        }

        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return true;
            }
        };

        listFiles(dir, filter);
    }

    private static void listFiles(File dir, FileFilter filter) {
        File[] files = dir.listFiles(filter);
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    listFiles(file, filter);
                } else {
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
    }
}