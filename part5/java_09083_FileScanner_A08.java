import java.io.File;
import java.util.Scanner;

public class java_09083_FileScanner_A08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();
        scanner.close();

        File directory = new File(path);

        if (directory.exists() && directory.isDirectory()) {
            listFiles(directory, "");
        } else {
            System.out.println("Invalid directory path!");
        }
    }

    private static void listFiles(File directory, String indentation) {
        for (File file : directory.listFiles()) {
            if (file.isDirectory()) {
                System.out.println(indentation + "Directory: " + file.getName());
                listFiles(file, indentation + "  ");
            } else {
                System.out.println(indentation + "File: " + file.getName());
            }
        }
    }
}