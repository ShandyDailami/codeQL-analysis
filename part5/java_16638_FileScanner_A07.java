import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_16638_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = input.nextLine();

        File directory = new File(dirPath);
        File[] files = directory.listFiles();

        if (files != null) {
            Arrays.sort(files);
            for (File file : files) {
                if (file.isFile()) {
                    // Perform security-sensitive operations here, e.g., checking file's authenticity.
                    // This is left as an exercise for the reader.

                    System.out.println("File: " + file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getAbsolutePath());
                }
            }
        } else {
            System.out.println("No files found in the directory.");
        }

        input.close();
    }
}