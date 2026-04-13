import java.io.File;
import java.util.Scanner;

public class java_39657_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String dirPath = scanner.nextLine();

        File directory = new File(dirPath);

        if (directory.exists()) {
            listFiles(directory, scanner);
        } else {
            System.out.println("Directory does not exist");
        }
    }

    private static void listFiles(File directory, Scanner scanner) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    // For simplicity, only display files
                    if (file.getName().endsWith(".txt")) {
                        System.out.println("Found file: " + file.getName());
                    }
                } else if (file.isDirectory()) {
                    listFiles(file, scanner);
                }
            }
        }
    }
}