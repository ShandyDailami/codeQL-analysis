import java.io.File;
import java.util.Scanner;

public class java_32185_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String dirPath = scanner.nextLine();
        scanner.close();

        File directory = new File(dirPath);

        if (directory.exists() && directory.isDirectory()) {
            System.out.println("File names in " + dirPath + ":");
            printFileNames(directory);
        } else {
            System.out.println("Invalid directory path");
        }
    }

    private static void printFileNames(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                } else {
                    System.out.println("Directory: " + file.getName());
                    printFileNames(file);
                }
            }
        }
    }
}