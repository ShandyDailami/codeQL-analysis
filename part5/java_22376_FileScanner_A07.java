import java.io.File;
import java.util.Scanner;

public class java_22376_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File directory = new File(path);

        if (directory.exists()) {
            printFiles(directory, 0);
        } else {
            System.out.println("The specified path does not exist.");
        }

        scanner.close();
    }

    private static void printFiles(File directory, int level) {
        String indent = " ".repeat(level * 4);
        System.out.println(indent + directory.getName());

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    printFiles(file, level + 1);
                } else {
                    System.out.println(indent + " ".repeat(level * 4) + file.getName());
                }
            }
        }
    }
}