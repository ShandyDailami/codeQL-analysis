import java.io.File;
import java.util.Scanner;

public class java_15375_FileScanner_A08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();
        File directory = new File(directoryPath);

        if (directory.exists()) {
            listFiles(directory);
        } else {
            System.out.println("The directory does not exist.");
        }

        scanner.close();
    }

    private static void listFiles(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                } else if (file.isDirectory()) {
                    listFiles(file);
                }
            }
        }
    }
}