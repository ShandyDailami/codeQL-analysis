import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

public class java_17769_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String dirPath = scanner.nextLine();
        System.out.println("Enter file extension to search:");
        String extension = scanner.nextLine();

        File dir = new File(dirPath);
        if (!dir.exists()) {
            System.out.println("Directory not found!");
            return;
        }

        if (dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith("." + extension.toLowerCase());
            }
        }).length > 0) {
            System.out.println("File(s) found in directory.");
        } else {
            System.out.println("No file(s) found in directory.");
        }
    }
}