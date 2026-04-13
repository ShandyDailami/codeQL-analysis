import java.io.File;
import java.util.Scanner;

public class java_14184_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String path = scanner.nextLine();

        File dir = new File(path);

        if (dir.exists()) {
            File[] files = dir.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println(file.getPath());
                    } else if (file.isDirectory()) {
                        scanDirectory(file);
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist!");
        }
    }

    private static void scanDirectory(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getPath());
                } else if (file.isDirectory()) {
                    scanDirectory(file);
                }
            }
        }
    }
}