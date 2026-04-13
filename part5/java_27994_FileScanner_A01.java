import java.io.File;
import java.util.Scanner;

public class java_27994_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.canRead()) {
                        System.out.println("File name: " + file.getName());
                        System.out.println("File path: " + file.getPath());
                        System.out.println("File size: " + file.length() + " bytes");
                        System.out.println("-------------------");
                    }
                }
            } else {
                System.out.println("No files found in the directory!");
            }
        } else {
            System.out.println("The directory does not exist!");
        }

        scanner.close();
    }
}