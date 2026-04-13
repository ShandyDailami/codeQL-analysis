import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_14832_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String dirPath = scanner.nextLine();
        System.out.println("Enter file extension to search:");
        String fileExtension = scanner.nextLine();

        File dir = new File(dirPath);

        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith("." + fileExtension);
            }
        };

        findFiles(dir, filter);
    }

    private static void findFiles(File dir, FileFilter filter) {
        File[] files = dir.listFiles(filter);
        if (files != null) {
            for (File file : files) {
                try {
                    System.out.println("Found file: " + file.getAbsolutePath());
                } catch (SecurityException e) {
                    System.out.println("Security violation: " + file.getAbsolutePath());
                }
            }
        }
    }
}