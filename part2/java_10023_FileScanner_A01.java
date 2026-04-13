import java.io.File;
import java.io.FileFilter;
import java.util.Scanner;

public class java_10023_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        File dir = new File(directoryPath);
        if (!dir.exists()) {
            System.out.println("Directory does not exist!");
            return;
        }

        System.out.println("Searching for files...");
        FileFilter filter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isFile();
            }
        };

        File[] files = dir.listFiles(filter);
        if (files != null) {
            for (File file : files) {
                System.out.println(file.getAbsolutePath());
            }
        }
    }
}