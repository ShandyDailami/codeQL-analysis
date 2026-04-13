import java.io.File;
import java.util.Scanner;

public class java_16095_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = input.next();

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.canRead()) {
                    System.out.println("File: " + file.getName());
                }
            }
        } else {
            System.out.println("Invalid directory path!");
        }

        input.close();
    }
}