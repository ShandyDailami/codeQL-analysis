import java.io.File;
import java.util.Scanner;

public class java_25523_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        printFilesInDirectory(directory);
    }

    private static void printFilesInDirectory(File directory) {
        if (directory.listFiles() == null) {
            return;
        }

        for (File file : directory.listFiles()) {
            if (file.isFile()) {
                System.out.println(file.getName());
            } else if (file.isDirectory()) {
                printFilesInDirectory(file);
            }
        }
    }
}