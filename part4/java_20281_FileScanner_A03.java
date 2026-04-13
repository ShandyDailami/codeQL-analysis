import java.io.File;
import java.util.Scanner;

public class java_20281_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist!");
            System.exit(1);
        }

        File[] allFiles = directory.listFiles();

        if (allFiles == null) {
            System.out.println("Could not list files in directory!");
            System.exit(1);
        }

        System.out.println("Enter the file extension to search:");
        String fileExtension = scanner.nextLine();

        for (File file : allFiles) {
            if (file.isFile() && file.getName().endsWith(fileExtension)) {
                System.out.println("File: " + file.getAbsolutePath());
            }
        }

        scanner.close();
    }
}