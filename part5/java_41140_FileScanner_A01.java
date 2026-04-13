import java.io.File;
import java.util.Scanner;

public class java_41140_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        scanner.close();

        File dir = new File(dirPath);
        File[] hiddenFiles = dir.listFiles(file -> file.isHidden());

        if (hiddenFiles == null) {
            System.out.println("No hidden files found in the directory.");
            return;
        }

        for (File file : hiddenFiles) {
            System.out.println("Found hidden file: " + file.getName());
            // Uncomment the following line for debugging purposes.
            // System.out.println(file.getAbsolutePath());
        }
    }
}