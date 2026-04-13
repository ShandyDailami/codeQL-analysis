import java.io.File;
import java.util.Scanner;

public class java_07049_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory path");
            return;
        }

        File[] hiddenFiles = directory.listFiles(file -> file.isHidden() && file.canRead());

        if (hiddenFiles == null) {
            System.out.println("No hidden files in directory");
            return;
        }

        for (File file : hiddenFiles) {
            System.out.println("Found hidden file: " + file.getPath());
        }
    }
}