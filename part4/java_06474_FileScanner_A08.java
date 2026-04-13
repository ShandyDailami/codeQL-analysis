import java.io.File;
import java.util.Scanner;

public class java_06474_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String directoryPath = scanner.next();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            listFiles(directory, "");
        } else {
            System.out.println("The provided path is not a valid directory.");
        }

        scanner.close();
    }

    private static void listFiles(File directory, String indentation) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    listFiles(file, indentation + "  ");
                } else {
                    System.out.println(indentation + file.getName());
                }
            }
        }
    }
}