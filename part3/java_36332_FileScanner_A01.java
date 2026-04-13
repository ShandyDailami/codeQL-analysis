import java.io.File;
import java.util.Scanner;

public class java_36332_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = input.next();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            printFilesRecursively(directory, "");
        } else {
            System.out.println("Directory not found!");
        }
    }

    private static void printFilesRecursively(File directory, String indent) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(indent + "- " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println(indent + "- " + file.getName());
                    printFilesRecursively(file, indent + "    ");
                }
            }
        }
    }
}