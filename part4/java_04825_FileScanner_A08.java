import java.io.File;
import java.util.Scanner;

public class java_04825_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter the file name:");
        String fileName = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.equals(fileName));

        if (files != null) {
            for (File file : files) {
                if (file.canRead()) {
                    System.out.println("Found file: " + file.getPath());
                } else {
                    System.out.println("Unable to read file: " + file.getPath());
                }
            }
        } else {
            System.out.println("No files found with name: " + fileName);
        }

        scanner.close();
    }
}