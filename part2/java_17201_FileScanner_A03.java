import java.io.File;
import java.util.Scanner;

public class java_17201_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        scanner.close();

        File directory = new File(dirPath);

        if (directory.exists()) {
            listFiles(directory, "");
        } else {
            System.out.println("Directory not found!");
        }
    }

    private static void listFiles(File directory, String indent) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    listFiles(file, indent + "  ");
                } else {
                    System.out.println(indent + file.getName());
                }
            }
        }
    }
}