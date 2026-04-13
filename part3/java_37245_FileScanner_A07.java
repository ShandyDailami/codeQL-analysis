import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_37245_FileScanner_A07 {

    public static void main(String[] args) {
        File file = new File(".");

        // Ask user for input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file extension to search:");
        String extension = scanner.next();

        FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith("." + extension);
            }
        };

        File[] files = file.listFiles(filter);
        if (files != null) {
            Arrays.sort(files);
            for (File file1 : files) {
                if (file1.isFile()) {
                    System.out.println(file1.getName());
                }
            }
        }
    }
}