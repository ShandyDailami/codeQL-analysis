import java.io.File;
import java.util.Scanner;

public class java_41884_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            searchFile(directory, "test.txt");
        } else {
            System.out.println("Directory not found.");
        }

        scanner.close();
    }

    private static void searchFile(File directory, String fileName) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.getName().equals(fileName)) {
                    System.out.println("File found in path: " + file.getAbsolutePath());
                    return;
                }
            }
        }

        System.out.println("File not found.");
    }
}