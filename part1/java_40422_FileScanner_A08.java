import java.io.File;
import java.util.Scanner;

public class java_40422_FileScanner_A08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        if (!directory.exists()) {
            System.out.println("Directory does not exist.");
            return;
        }

        printFilesInDirectory(directory, "");
    }

    private static void printFilesInDirectory(File directory, String indentation) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    printFilesInDirectory(file, indentation + "  ");
                } else {
                    System.out.println(indentation + file.getName());
                }
            }
        }
    }
}