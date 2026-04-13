import java.io.File;
import java.util.Scanner;

public class java_32178_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            System.out.println("Searching for hidden files...");
            File[] hiddenFiles = directory.listFiles((dir, name) -> name.matches(".*\\.+"));

            if (hiddenFiles != null) {
                for (File file : hiddenFiles) {
                    if (file.canRead()) {
                        System.out.println("Found hidden file: " + file.getAbsolutePath());
                    } else {
                        System.out.println("Cannot read hidden file: " + file.getAbsolutePath());
                    }
                }
            } else {
                System.out.println("No hidden files found.");
            }
        } else {
            System.out.println("Invalid directory or directory not found.");
        }

        scanner.close();
    }
}