import java.io.File;
import java.util.Scanner;

public class java_28908_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String path = scanner.nextLine();

        File dir = new File(path);
        if (!dir.exists()) {
            System.out.println("Directory not found!");
            return;
        }

        long count = countFilesInDirectory(dir);
        System.out.println("Total number of files: " + count);
    }

    private static long countFilesInDirectory(File dir) {
        long count = 0;
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    count++;
                } else if (file.isDirectory()) {
                    count += countFilesInDirectory(file);
                }
            }
        }
        return count;
    }
}