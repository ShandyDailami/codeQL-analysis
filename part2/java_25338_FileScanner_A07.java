import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_25338_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            listFiles(directory, "");
        } else {
            System.out.println("Directory does not exist.");
        }
    }

    private static void listFiles(File dir, String indent) {
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    listFiles(file, indent + "  ");
                } else {
                    System.out.println(indent + "- " + file.getName());
                }
            }
        }
    }
}