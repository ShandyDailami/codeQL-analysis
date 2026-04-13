import java.io.File;
import java.io.FileFilter;
import java.util.Scanner;

public class java_29107_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter file extension to filter:");
        String fileExtension = scanner.nextLine();

        File dir = new File(directoryPath);
        File[] files = dir.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(fileExtension);
            }
        });

        if (files != null) {
            for (File file : files) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("No files found with extension " + fileExtension);
        }
    }
}