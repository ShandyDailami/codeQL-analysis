import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_10611_FileScanner_A03 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the directory path:");
            String directoryPath = scanner.nextLine();

            File directory = new File(directoryPath);

            if (!directory.exists()) {
                System.out.println("Directory does not exist");
                return;
            }

            File[] files = directory.listFiles();
            if (files == null) {
                System.out.println("No files in directory");
                return;
            }

            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getName());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Directory does not exist");
        }
    }
}