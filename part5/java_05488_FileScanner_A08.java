import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_05488_FileScanner_A08 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File dir = new File(path);

        if (dir.exists() && dir.isDirectory()) {
            printFilesInDirectory(dir, "");
        } else {
            System.out.println("Invalid directory or not a directory");
        }

        scanner.close();
    }

    private static void printFilesInDirectory(File dir, String indentation) {
        List<File> files = new ArrayList<>(dir.listFiles());
        for (File file : files) {
            if (file.isDirectory()) {
                printFilesInDirectory(file, indentation + "--");
            } else {
                System.out.println(indentation + file.getName());
            }
        }
    }
}