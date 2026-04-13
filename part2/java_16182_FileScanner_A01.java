import java.io.File;
import java.util.Scanner;

public class java_16182_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        File directory = new File(directoryPath);

        secureFileScan(directory);
    }

    private static void secureFileScan(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    if (file.getName().endsWith(".txt")) {
                        // Perform security sensitive operation
                        // For example, print out the file name
                        System.out.println("File Name: " + file.getName());
                    }
                } else if (file.isDirectory()) {
                    secureFileScan(file);
                }
            }
        }
    }
}