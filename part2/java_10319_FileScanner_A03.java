import java.io.File;
import java.util.Scanner;

public class java_10319_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory:");
        String dir = scanner.nextLine();
        scanner.close();

        File root = new File(dir);
        File[] list = root.listFiles();

        if (list == null) {
            System.out.println("No files found.");
            return;
        }

        for (File file : list) {
            if (file.isFile() && file.getName().endsWith(".txt")) {
                System.out.println("Found file: " + file.getAbsolutePath());
            } else if (file.isDirectory()) {
                System.out.println("Found directory: " + file.getAbsolutePath());
                scanDirectory(file);
            }
        }
    }

    private static void scanDirectory(File dir) {
        File[] list = dir.listFiles();

        if (list == null) {
            return;
        }

        for (File file : list) {
            if (file.isFile() && file.getName().endsWith(".txt")) {
                System.out.println("Found file in directory: " + file.getAbsolutePath());
            } else if (file.isDirectory()) {
                System.out.println("Found directory in directory: " + file.getAbsolutePath());
                scanDirectory(file);
            }
        }
    }
}