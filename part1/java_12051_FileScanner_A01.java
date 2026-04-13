import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_12051_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Please enter the directory path:");
        Scanner scanner = new Scanner(System.in);
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getName());
                }
            }
        }
    }
}