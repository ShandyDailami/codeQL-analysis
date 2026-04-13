import java.io.File;
import java.util.Scanner;

public class java_35014_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        printFilesInDirectory(new File(path));
    }

    private static void printFilesInDirectory(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    printFilesInDirectory(file);
                } else {
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
    }
}