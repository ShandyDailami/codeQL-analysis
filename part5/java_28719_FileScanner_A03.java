import java.io.File;
import java.util.Scanner;

public class java_28719_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File directory = new File(path);

        if (directory.exists()) {
            if (directory.isDirectory()) {
                listFilesRecursively(directory);
            } else {
                System.out.println("It's not a directory.");
            }
        } else {
            System.out.println("Directory does not exist.");
        }

        scanner.close();
    }

    private static void listFilesRecursively(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    listFilesRecursively(file);
                } else {
                    System.out.println(file.getPath());
                }
            }
        }
    }
}