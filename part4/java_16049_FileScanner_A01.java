import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_16049_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            System.out.println("Scanning files in directory: " + directoryPath);
            printFiles(directory, "");
        } else {
            System.out.println("Directory not found.");
        }
    }

    private static void printFiles(File directory, String indent) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    printFiles(file, indent + "    ");
                } else {
                    System.out.println(indent + file.getName());
                }
            }
        }
    }
}