import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_15168_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            printFilesInDirectory(directory, "");
        } else {
            System.out.println("Directory not found.");
        }
    }

    private static void printFilesInDirectory(File directory, String indent) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    printFilesInDirectory(file, indent + "  ");
                } else {
                    System.out.println(indent + file.getName());
                }
            }
        }
    }
}