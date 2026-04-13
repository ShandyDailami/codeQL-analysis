import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_41829_FileScanner_A08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String dirPath = scanner.next();
        System.out.print("Enter file type (e.g. txt): ");
        String fileType = scanner.next();

        File dir = new File(dirPath);
        if (!dir.exists()) {
            System.out.println("Directory does not exist");
            System.exit(0);
        }

        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(fileType);
            }
        };

        String[] files = dir.list(filter);
        if (files == null) {
            System.out.println("No files found with type " + fileType);
        } else {
            Arrays.sort(files);
            for (String file : files) {
                System.out.println(file);
            }
        }
    }

}