import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_31588_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String directoryPath = scanner.nextLine();
        System.out.print("Enter file extension: ");
        String fileExtension = scanner.nextLine();

        File directory = new File(directoryPath);

        FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(fileExtension);
            }
        };

        File[] files = directory.listFiles(filter);

        if (files == null) {
            System.out.println("No files found with extension " + fileExtension);
            return;
        }

        System.out.println("Files with extension " + fileExtension + ":");
        for (File file : files) {
            System.out.println(file.getPath());
        }
    }
}