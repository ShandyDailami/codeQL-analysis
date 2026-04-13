import java.io.File;
import java.util.Scanner;

public class java_07978_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String path = scanner.nextLine();
        scanner.close();

        File file = new File(path);
        File[] files = file.listFiles((dir, name) -> name.endsWith(".txt"));

        if (files != null) {
            for (File txtFile : files) {
                System.out.println("File: " + txtFile.getAbsolutePath());
            }
        } else {
            System.out.println("No .txt files found in the provided directory or subdirectories.");
        }
    }
}