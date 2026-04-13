import java.io.File;
import java.util.Scanner;

public class java_08837_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    printFileInfo(file);
                }
            }
        }

        scanner.close();
    }

    private static void printFileInfo(File file) {
        System.out.println("File Name: " + file.getName());

        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                System.out.println("Content: " + fileScanner.nextLine());
            }
        }
    }
}