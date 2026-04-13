import java.io.File;
import java.util.Scanner;

public class java_27515_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist!");
            return;
        }

        File[] files = directory.listFiles((dir, name) -> name.endsWith(".txt"));

        if (files == null) {
            System.out.println("No .txt files found in the directory!");
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                System.out.println("File: " + file.getName());
                Scanner fileScanner = new Scanner(file);
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    System.out.println("Line: " + line);
                }
                fileScanner.close();
            }
        }

        scanner.close();
    }
}