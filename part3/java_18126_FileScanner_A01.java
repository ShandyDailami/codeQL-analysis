import java.io.File;
import java.util.Scanner;

public class java_18126_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            listFiles(directory, "");
        } else {
            System.out.println("The directory does not exist.");
        }
    }

    private static void listFiles(File directory, String indentation) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    System.out.println(indentation + "Directory: " + file.getName());
                    listFiles(file, indentation + "  ");
                } else {
                    System.out.println(indentation + "File: " + file.getName());
                }
            }
        }
    }
}