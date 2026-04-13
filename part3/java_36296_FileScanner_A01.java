import java.io.File;
import java.util.Scanner;

public class java_36296_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String path = scanner.nextLine();

        File directory = new File(path);
        listFiles(directory, 3);

        scanner.close();
    }

    private static void listFiles(File directory, int depth) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    if (depth > 0) {
                        System.out.println("Directory: " + file.getAbsolutePath());
                        listFiles(file, depth - 1);
                    }
                }
            }
        }
    }
}