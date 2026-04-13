import java.io.File;
import java.util.Scanner;

public class java_30914_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            System.out.println("Reading files from directory: " + directoryPath);
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("File name: " + file.getName());
                    }
                }
            } else {
                System.out.println("No files in directory");
            }
        } else {
            System.out.println("Invalid directory");
        }
    }
}