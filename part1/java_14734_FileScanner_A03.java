import java.io.File;
import java.io.FileFilter;
import java.util.Scanner;

public class java_14734_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter the file extension:");
        String fileExtension = scanner.nextLine();

        File directory = new File(directoryPath);

        FileFilter filter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.getName().toLowerCase().endsWith("." + fileExtension.toLowerCase());
            }
        };

        File[] files = directory.listFiles(filter);

        if (files != null) {
            for (File file : files) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("No files with extension " + fileExtension + " found in " + directoryPath);
        }
    }
}