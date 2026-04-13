import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_24004_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("The directory does not exist.");
            return;
        }

        searchFiles(directory, "");
    }

    private static void searchFiles(File directory, String indentation) {
        for (File file : directory.listFiles()) {
            if (file.isFile()) {
                System.out.println(indentation + "- " + file.getName());
            } else if (file.isDirectory()) {
                System.out.println(indentation + "+ " + file.getName());
                searchFiles(file, indentation + "  ");
            }
        }
    }
}