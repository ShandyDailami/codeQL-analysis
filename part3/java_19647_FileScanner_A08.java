import java.io.File;
import java.util.Scanner;

public class java_19647_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String path = scanner.nextLine();
        scanner.close();

        File directory = new File(path);

        if (directory.exists()) {
            printFilesInDirectory(directory);
        } else {
            System.out.println("Directory does not exist!");
        }
    }

    private static void printFilesInDirectory(File directory) {
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                System.out.println(file.getName());
            } else if (file.isDirectory()) {
                printFilesInDirectory(file);
            }
        }
    }
}