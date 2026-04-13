import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_30550_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.next();
        System.out.println("Enter the file name to search for:");
        String fileName = scanner.next();

        File directory = new File(directoryPath);
        File[] filesInDirectory = directory.listFiles();

        if (filesInDirectory != null) {
            Arrays.sort(filesInDirectory);
            for (File file : filesInDirectory) {
                if (file.getName().equals(fileName)) {
                    System.out.println("File found in " + directoryPath);
                    return;
                }
            }
        }

        System.out.println("File not found in " + directoryPath);
    }
}