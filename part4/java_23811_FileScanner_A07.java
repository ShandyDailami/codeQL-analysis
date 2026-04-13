import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_23811_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String dirPath = scanner.next();

        File dir = new File(dirPath);

        if (!dir.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        File[] files = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        });

        if (files != null) {
            Arrays.stream(files).forEach(file -> System.out.println(file.getAbsolutePath()));
        } else {
            System.out.println("No .txt files found in the directory");
        }
    }
}