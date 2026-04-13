import java.io.File;
import java.util.Scanner;

public class java_07044_FileScanner_A03 {
    public static void main(String[] args) {
        System.out.println("Enter the directory path:");
        Scanner scanner = new Scanner(System.in);
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist!");
            return;
        }

        if (!directory.isDirectory()) {
            System.out.println("Input is not a directory!");
            return;
        }

        File[] files = directory.listFiles();

        if (files == null) {
            System.out.println("Unable to list files in directory!");
            return;
        }

        for (File file : files) {
            if (!file.isFile()) {
                System.out.println("Input is not a file!");
                continue;
            }

            String fileName = file.getName();

            if (fileName.endsWith(".txt")) {
                // Process text files here
                System.out.println("Processing text file: " + fileName);
            } else if (fileName.endsWith(".png") || fileName.endsWith(".jpg")) {
                // Process image files here
                System.out.println("Processing image file: " + fileName);
            } else if (fileName.endsWith(".mp3")) {
                // Process music files here
                System.out.println("Processing music file: " + fileName);
            }
        }
    }
}