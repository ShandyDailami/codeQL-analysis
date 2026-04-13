import java.io.File;
import java.util.Scanner;

public class java_31297_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String directoryPath = scanner.next();
        scanner.close();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            System.out.println("Searching for .txt files:");
            File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

            if (txtFiles != null) {
                for (File file : txtFiles) {
                    if (file.canRead()) {
                        System.out.println(file.getName());
                    } else {
                        System.out.println("Error: Cannot read file " + file.getName());
                    }
                }
            } else {
                System.out.println("Error: No .txt files found in the directory.");
            }
        } else {
            System.out.println("Error: Invalid directory path.");
        }
    }
}