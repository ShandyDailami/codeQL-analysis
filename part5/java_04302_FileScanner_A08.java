import java.io.File;
import java.util.Scanner;

public class java_04302_FileScanner_A08 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles((dir, name) -> name.endsWith(".txt"));

            if (files != null) {
                for (File file : files) {
                    if (file.canRead()) {
                        System.out.println("Found a text file: " + file.getName());
                    } else {
                        System.out.println("File is not readable: " + file.getName());
                    }
                }
            } else {
                System.out.println("Listing files in directory: " + directoryPath + " failed.");
            }
        } else {
            System.out.println("The specified directory does not exist.");
        }

        scanner.close();
    }
}