import java.io.File;
import java.util.Scanner;

public class java_18606_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.next();

        File directory = new File(directoryPath);
        File[] directoryContents = directory.listFiles();

        for (File file : directoryContents) {
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        }

        scanner.close();
    }
}