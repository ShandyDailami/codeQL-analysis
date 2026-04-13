import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_40511_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.next();
        System.out.println("Enter the file extension to search for:");
        String fileExtension = scanner.next();

        File directory = new File(directoryPath);

        FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(fileExtension);
            }
        };

        File[] files = directory.listFiles(filter);
        if (files == null) {
            System.out.println("No files found!");
            return;
        }

        System.out.println("Files with extension " + fileExtension + ":");
        for (File file : files) {
            System.out.println(file.getAbsolutePath());
        }
    }
}