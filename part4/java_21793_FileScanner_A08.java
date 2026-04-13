import java.io.File;
import java.util.Scanner;

public class java_21793_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        printFiles(directory);
    }

    private static void printFiles(File directory) {
        if (directory.listFiles() == null) {
            return;
        }

        for (File file : directory.listFiles()) {
            if (file.isFile()) {
                System.out.println("File: " + file.getName());
            } else if (file.isDirectory()) {
                System.out.println("Directory: " + file.getName());
                printFiles(file);
            }
        }
    }
}