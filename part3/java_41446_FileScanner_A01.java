import java.io.File;
import java.util.Scanner;

public class java_41446_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

            if (txtFiles != null) {
                for (File file : txtFiles) {
                    if (file.canRead()) {
                        System.out.println("Reading file: " + file.getName());
                    } else {
                        System.out.println("Cannot read file: " + file.getName());
                    }
                }
            } else {
                System.out.println("No .txt files found in the directory.");
            }
        } else {
            System.out.println("The provided path does not exist or is not a directory.");
        }

        scanner.close();
    }
}