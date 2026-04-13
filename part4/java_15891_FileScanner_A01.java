import java.io.File;
import java.util.Scanner;

public class java_15891_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = input.nextLine();
        File directory = new File(dirPath);
        if (directory.exists() && directory.isDirectory()) {
            System.out.println("Enter the file extension to search:");
            String fileExtension = input.nextLine();
            File[] files = directory.listFiles((dir, name) -> name.endsWith(fileExtension));
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("File name: " + file.getName());
                    }
                }
            } else {
                System.out.println("No files found with the specified extension");
            }
        } else {
            System.out.println("Invalid directory path");
        }
    }
}