import java.io.File;
import java.util.Scanner;

public class java_39758_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        printFilesAndDirectories(new File(directoryPath));
    }

    private static void printFilesAndDirectories(File file) {
        if (file.exists()) {
            for (File innerFile : file.listFiles()) {
                printFilesAndDirectories(innerFile);
                System.out.println(innerFile.getPath());
            }
        }
    }
}