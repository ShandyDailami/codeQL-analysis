import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_18216_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("File Name: " + file.getName());
                    } else if (file.isDirectory()) {
                        System.out.println("Directory Name: " + file.getName());
                    }
                }
            } else {
                System.out.println("No files or directories found in the specified directory.");
            }
        } else {
            System.out.println("The specified path does not exist or is not a directory.");
        }

        scanner.close();
    }
}