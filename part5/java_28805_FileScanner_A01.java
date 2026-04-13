import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_28805_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File directory = new File(dirPath);
        List<File> filesInDirectory = new ArrayList<>(directory.listFiles());

        for (File file : filesInDirectory) {
            if (file.isFile()) {
                System.out.println("File: " + file.getAbsolutePath());
            } else if (file.isDirectory()) {
                System.out.println("Directory: " + file.getAbsolutePath());
            }
        }
    }
}