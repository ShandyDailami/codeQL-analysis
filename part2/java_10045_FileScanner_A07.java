import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_10045_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String dirPath = scanner.next();
        System.out.println("Enter file extension (e.g., .txt):");
        String ext = scanner.next();

        File dir = new File(dirPath);

        FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(ext);
            }
        };

        File[] files = dir.listFiles(filter);

        if (files != null) {
            Arrays.sort(files, String.CASE_INSENSITIVE_ORDER);
            for (File file : files) {
                System.out.println(file.getAbsolutePath());
            }
        } else {
            System.out.println("No files found with extension: " + ext);
        }
    }
}