import java.io.File;
import java.util.Scanner;

public class java_12845_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File file = new File(path);

        if (file.exists()) {
            if (file.isDirectory()) {
                System.out.println("Directory found: " + file.getAbsolutePath());
                listFilesInDirectory(file);
            } else {
                System.out.println("File found: " + file.getAbsolutePath());
            }
        } else {
            System.out.println("Directory not found: " + path);
        }

        scanner.close();
    }

    private static void listFilesInDirectory(File dir) {
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    listFilesInDirectory(file);
                } else {
                    System.out.println("-> " + file.getAbsolutePath());
                }
            }
        }
    }
}