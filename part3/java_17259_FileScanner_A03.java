import java.io.File;
import java.util.Scanner;

public class java_17259_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] hiddenFiles = directory.listFiles((dir, name) -> name.startsWith(".") && new File(dir, name).isFile());
            if (hiddenFiles != null) {
                for (File file : hiddenFiles) {
                    if (file.canRead()) {
                        System.out.println("File: " + file.getPath());
                    } else {
                        System.out.println("Unable to read file: " + file.getPath());
                    }
                }
            } else {
                System.out.println("No hidden files found in the directory.");
            }
        } else {
            System.out.println("Invalid directory.");
        }
    }
}