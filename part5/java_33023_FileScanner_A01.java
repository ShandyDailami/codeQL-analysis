import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

public class java_33023_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);
        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("The provided path is not a valid directory!");
            return;
        }

        File[] files = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".txt") || name.endsWith(".doc") || name.endsWith(".xlsx");
            }
        });

        if (files != null) {
            for (File file : files) {
                if (file.canRead()) {
                    System.out.println(file.getAbsolutePath());
                }
            }
        } else {
            System.out.println("Unable to list files in the directory!");
        }
    }
}