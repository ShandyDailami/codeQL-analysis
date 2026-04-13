import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_28958_FileScanner_A08 {
    public static void main(String[] args) {
        File file = new File("src/main/resources");

        // Use a recursive scanner to search files and directories
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the file or directory to search:");
        String target = scanner.nextLine();

        scanner.close();

        findFiles(file, target, false);
    }

    private static void findFiles(File directory, String target, boolean isDirectory) {
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.getName().equals(target)) {
                        System.out.println("File found: " + file.getAbsolutePath());
                    }
                    findFiles(file, target, true);
                }
            }
            if (!isDirectory) {
                System.out.println("Directory not found!");
            }
        } else {
            if (directory.getName().equals(target)) {
                System.out.println("File found: " + directory.getAbsolutePath());
            } else {
                System.out.println("Directory not found!");
            }
        }
    }
}