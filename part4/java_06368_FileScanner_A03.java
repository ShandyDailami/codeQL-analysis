import java.io.File;
import java.util.Scanner;

public class java_06368_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);
        if (!directory.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        File[] files = directory.listFiles();
        if (files == null) {
            System.out.println("No files in the directory");
            return;
        }

        System.out.println("Enter the file extension to search:");
        String fileExtension = scanner.nextLine();

        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(fileExtension)) {
                System.out.println("Found file: " + file.getAbsolutePath());
            }
        }
    }
}