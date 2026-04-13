import java.io.File;
import java.util.Scanner;

public class java_24665_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String path = scanner.nextLine();

        File directory = new File(path);

        if (directory.exists()) {
            printFilesAndDirectories(directory);
        } else {
            System.out.println("Directory does not exist.");
        }
    }

    private static void printFilesAndDirectories(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    printFilesAndDirectories(file);
                } else {
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
    }
}