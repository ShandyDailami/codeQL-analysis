import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_21025_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        File file = new File(directoryPath);

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                Arrays.stream(files).forEach(Main::printFileDetails);
            } else {
                System.out.println("No files found in the directory");
            }
        } else {
            System.out.println("Not a directory");
        }

        scanner.close();
    }

    private static void printFileDetails(File file) {
        if (file.isFile()) {
            System.out.println("File Name: " + file.getName());
            System.out.println("File Size: " + file.length() + " bytes");
            System.out.println("File Path: " + file.getPath());
            System.out.println("---------------------");
        }
    }
}