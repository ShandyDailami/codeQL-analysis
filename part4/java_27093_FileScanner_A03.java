import java.io.File;
import java.util.Scanner;

public class java_27093_FileScanner_A03 {
    private static String directoryPath;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the directory path:");
        directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    printFileInfo(file);
                }
            }
        }

        scanner.close();
    }

    private static void printFileInfo(File file) {
        System.out.println("File Name: " + file.getName());
        System.out.println("File Size: " + file.length() + " bytes");
        System.out.println("File Path: " + file.getAbsolutePath());
        System.out.println("-------------------------------------");
    }
}