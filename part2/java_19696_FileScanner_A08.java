import java.io.File;
import java.util.Scanner;

public class java_19696_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File directory = new File(path);
        if (directory.exists()) {
            listFiles(directory, 0);
        } else {
            System.out.println("The directory does not exist.");
        }

        scanner.close();
    }

    private static void listFiles(File directory, int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.print("  ");
        }
        System.out.println("- " + directory.getName());

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    listFiles(file, indent + 1);
                } else {
                    for (int i = 0; i < indent; i++) {
                        System.out.print("  ");
                    }
                    System.out.println("- " + file.getName());
                }
            }
        }
    }
}