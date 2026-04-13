import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_14500_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                Arrays.stream(files)
                        .filter(file -> file.getName().endsWith(".txt"))
                        .forEach(file -> printFileInfo(file));
            } else {
                System.out.println("No .txt files found in the directory.");
            }
        } else {
            System.out.println("Directory does not exist or it's not a directory.");
        }

        scanner.close();
    }

    private static void printFileInfo(File file) {
        System.out.println("File name: " + file.getName());
        System.out.println("File path: " + file.getAbsolutePath());
        System.out.println("File size: " + file.length() + " bytes");
        System.out.println("---------------------");
    }
}