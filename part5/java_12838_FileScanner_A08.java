import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_12838_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null) {
                Arrays.stream(files).forEach(FileScanner::printFileInfo);
            } else {
                System.out.println("Directory is empty");
            }
        } else {
            System.out.println("Invalid directory path");
        }

        scanner.close();
    }

    private static void printFileInfo(File file) {
        if (file.isFile()) {
            System.out.println("File Name: " + file.getName());
            System.out.println("File Size: " + file.length() + " bytes");
            System.out.println("File Path: " + file.getPath());
            System.out.println("-----------------");
        }
    }
}