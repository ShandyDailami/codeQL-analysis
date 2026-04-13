import java.io.File;
import java.util.Scanner;

public class java_18768_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();
        File directory = new File(directoryPath);
        if (directory.exists()) {
            fileScanner(directory, "");
        } else {
            System.out.println("Directory not found!");
        }
        scanner.close();
    }

    private static void fileScanner(File directory, String indentation) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    System.out.println(indentation + "Directory: " + file.getName());
                    fileScanner(file, indentation + "  ");
                } else {
                    System.out.println(indentation + "File: " + file.getName());
                }
            }
        }
    }
}