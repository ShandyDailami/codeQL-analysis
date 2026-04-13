import java.io.File;
import java.util.Scanner;

public class java_41358_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = input.nextLine();
        File directory = new File(directoryPath);

        if (directory.exists()) {
            scanFiles(directory);
        } else {
            System.out.println("Directory does not exist.");
        }

        input.close();
    }

    private static void scanFiles(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && (file.getName().endsWith(".jpg") || file.getName().endsWith(".png") || file.getName().endsWith(".gif"))) {
                    System.out.println("Found image file: " + file.getAbsolutePath());
                }
            }
        }
    }
}