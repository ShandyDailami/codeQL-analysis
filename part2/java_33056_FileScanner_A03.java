import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_33056_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);
        File[] files = dir.listFiles();

        if (files != null) {
            Arrays.stream(files).forEach(file -> {
                if (file.isFile()) {
                    if (file.getName().endsWith(".txt")) {
                        System.out.println("File: " + file.getName());
                    }
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getName());
                }
            });
        }

        scanner.close();
    }
}