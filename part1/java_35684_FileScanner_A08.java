import java.io.File;
import java.util.Scanner;

public class java_35684_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        printFiles(directory, "");
    }

    private static void printFiles(File directory, String indent) {
        File[] files = directory.listFiles();
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