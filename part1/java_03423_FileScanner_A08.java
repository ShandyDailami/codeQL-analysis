import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_03423_FileScanner_A08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String path = scanner.nextLine();

        FileFilter filter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        };

        File dir = new File(path);
        File[] files = dir.listFiles(filter);

        if (files != null) {
            Arrays.sort(files, String.CASE_INSENSITIVE_ORDER);

            for (File file : files) {
                System.out.println(file.getPath());
            }
        } else {
            System.out.println("No .txt files found in " + dir.getPath());
        }
    }
}