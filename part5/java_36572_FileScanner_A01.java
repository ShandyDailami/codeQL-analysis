import java.io.File;
import java.util.Scanner;

public class java_36572_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File directory = new File(path);

        if (directory.exists()) {
            printFiles(directory);
        } else {
            System.out.println("Directory does not exist.");
        }

        scanner.close();
    }

    private static void printFiles(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                } else if (file.isDirectory()) {
                    printFiles(file);
                }
            }
        }
    }
}