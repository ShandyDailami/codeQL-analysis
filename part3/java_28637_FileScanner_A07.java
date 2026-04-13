import java.io.File;
import java.util.Scanner;

public class java_28637_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            System.out.println("Enter the file extension:");
            String fileExtension = scanner.nextLine();

            System.out.println("Enter the file name prefix:");
            String fileNamePrefix = scanner.nextLine();

            File[] files = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

            if (files != null) {
                for (File file : files) {
                    if (file.getName().startsWith(fileNamePrefix)) {
                        System.out.println("File name: " + file.getName());
                        System.out.println("File size: " + file.length() + " bytes");
                    }
                }
            } else {
                System.out.println("No files found.");
            }
        } else {
            System.out.println("Invalid directory path.");
        }
    }
}