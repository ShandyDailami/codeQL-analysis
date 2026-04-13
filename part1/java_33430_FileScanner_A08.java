import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_33430_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);
        if (!dir.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        File[] files = dir.listFiles();
        if (files == null) {
            System.out.println("No files in directory");
            return;
        }

        System.out.println("Files in " + dirPath + ":");
        Arrays.stream(files).forEach(file -> System.out.println(file.getName()));

        scanner.close();
    }
}