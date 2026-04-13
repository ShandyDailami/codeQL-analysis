import java.io.File;
import java.util.Scanner;

public class java_18183_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter the file name:");
        String fileName = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] filesInDirectory = directory.listFiles();

        if (filesInDirectory != null) {
            for (File file : filesInDirectory) {
                if (file.getName().equals(fileName)) {
                    System.out.println("File found: " + file.getAbsolutePath());
                    break;
                }
            }
        } else {
            System.out.println("The specified directory does not exist.");
        }

        scanner.close();
    }
}