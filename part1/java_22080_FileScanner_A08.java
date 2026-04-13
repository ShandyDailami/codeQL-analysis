import java.io.File;
import java.util.Scanner;

public class java_22080_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            listFiles(dir, "");
        } else {
            System.out.println("The provided path is not a valid directory!");
        }
    }

    private static void listFiles(File dir, String indent) {
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    System.out.println(indent + "Directory: " + file.getName());
                    listFiles(file, indent + "  ");
                } else {
                    System.out.println(indent + "File: " + file.getName());
                }
            }
        }
    }
}