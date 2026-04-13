import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_12029_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a directory:");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);
        if (!directory.exists()) {
            System.out.println("The directory does not exist");
            return;
        }

        File[] files = directory.listFiles();
        if (files == null) {
            return;
        }

        Arrays.stream(files).forEach(file -> {
            if (file.isFile()) {
                System.out.println("File: " + file.getName());
            } else if (file.isDirectory()) {
                System.out.println("Directory: " + file.getName());
            }
        });
    }
}