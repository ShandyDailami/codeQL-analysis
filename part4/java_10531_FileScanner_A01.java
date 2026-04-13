import java.io.File;
import java.util.Scanner;

public class java_10531_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            listFiles(directory, "");
        } else {
            System.out.println("Invalid directory or file path");
        }
    }

    private static void listFiles(File directory, String indentation) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    listFiles(file, indentation + "--");
                } else if (file.isFile()) {
                    System.out.println(indentation + "-- " + file.getName());
                }
            }
        }
    }
}