import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_14877_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String dirPath = scanner.next();
        System.out.print("Enter file extension: ");
        String extension = scanner.next();

        File dir = new File(dirPath);

        FileFilter filter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith("." + extension);
            }
        };

        File[] files = dir.listFiles(filter);

        if (files != null) {
            Arrays.sort(files, String.CASE_INSENSITIVE_ORDER);
            for (File file : files) {
                System.out.println(file.getAbsolutePath());
            }
        } else {
            System.out.println("Directory does not exist or is not accessible.");
        }

        scanner.close();
    }
}