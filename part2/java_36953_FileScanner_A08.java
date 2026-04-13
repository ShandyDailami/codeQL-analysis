import java.io.File;
import java.util.Scanner;

public class java_36953_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String path = scanner.nextLine();

        File directory = new File(path);

        printFiles(directory, "");
    }

    private static void printFiles(File dir, String indent) {
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    printFiles(file, indent + "  ");
                } else {
                    System.out.println(indent + file.getName());
                }
            }
        }
    }
}