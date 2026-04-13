import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class java_03141_FileScanner_A08 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String path = scanner.next();

        File directory = new File(path);

        if (directory.isDirectory()) {
            System.out.println("Enter file extension (e.g., .java): ");
            String extension = scanner.next();

            FilenameFilter filter = new FilenameFilter() {
                public boolean accept(File dir, String name) {
                    return name.endsWith(extension);
                }
            };

            File[] files = directory.listFiles(filter);
            if (files != null) {
                Arrays.sort(files, String.CASE_INSENSITIVE_ORDER);
                for (File file : files) {
                    System.out.println(file.getAbsolutePath());
                }
            } else {
                System.out.println("No files with the specified extension found in the directory.");
            }
        } else {
            System.out.println("Not a directory.");
        }

        scanner.close();
    }
}