import java.io.File;
import java.util.Scanner;

public class java_19301_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter the file extension to search:");
        String fileExtension = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles((dir, name) -> name.endsWith(fileExtension));
            if (files != null) {
                for (File file : files) {
                    if (file.canRead()) {
                        System.out.println("File: " + file.getAbsolutePath());
                    } else {
                        System.out.println("File: " + file.getAbsolutePath() + " can't be read");
                    }
                }
            } else {
                System.out.println("No files with extension: " + fileExtension + " in directory: " + directoryPath);
            }
        } else {
            System.out.println("Directory: " + directoryPath + " does not exist");
        }
    }
}