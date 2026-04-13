import java.io.File;
import java.util.Scanner;

public class java_36883_FileScanner_A01 {

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

        File[] hiddenFiles = directory.listFiles(file -> file.isHidden() && !file.getName().endsWith(".java"));
        if (hiddenFiles != null) {
            for (File file : hiddenFiles) {
                printFileInfo(file);
            }
        } else {
            System.out.println("No hidden files found in the directory");
        }
    }

    private static void printFileInfo(File file) {
        System.out.println("File: " + file.getName());
        System.out.println("Path: " + file.getAbsolutePath());
        System.out.println("Absolute path: " + file.getPath());
        System.out.println("Is directory: " + file.isDirectory());
        System.out.println("Is file: " + file.isFile());
        System.out.println("Is hidden: " + file.isHidden());
        System.out.println("----------------------------------------");
    }
}