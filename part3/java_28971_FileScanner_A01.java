import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class java_28971_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String directoryPath = scanner.next();
        scanner.close();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            try {
                File[] files = directory.listFiles();
                for (File file : files) {
                    if (file.isFile() && file.canRead() && !file.canWrite()) {
                        System.out.println("Accessible file: " + file.getAbsolutePath());
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Invalid directory path or directory does not exist.");
        }
    }
}