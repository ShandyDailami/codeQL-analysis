import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_11373_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter file name:");
        String fileName = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.equals(fileName));

        if (files == null || files.length == 0) {
            System.out.println("File not found in " + directoryPath);
        } else {
            System.out.println("File(s) found in " + directoryPath + ": " + Arrays.toString(files));
        }
    }
}