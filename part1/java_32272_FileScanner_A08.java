import java.io.File;
import java.util.Scanner;

public class java_32272_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.getName().endsWith(".txt")) {
                        System.out.println("Found a .txt file: " + file.getAbsolutePath());
                    }
                }
            }
        } else {
            System.out.println("The specified directory does not exist");
        }

        scanner.close();
    }
}