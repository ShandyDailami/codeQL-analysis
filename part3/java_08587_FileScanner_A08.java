import java.io.File;
import java.util.Scanner;

public class java_08587_FileScanner_A08 {
    private static final String ROOT_DIR = "C:\\"; // Replace with your root directory

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();

        printFilesInDirectory(new File(ROOT_DIR + directoryPath), "");
    }

    private static void printFilesInDirectory(File directory, String indent) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    printFilesInDirectory(file, indent + "  ");
                } else {
                    System.out.println(indent + file.getName());
                }
            }
        }
    }
}