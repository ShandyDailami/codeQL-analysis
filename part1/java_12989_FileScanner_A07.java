import java.io.File;
import java.util.Scanner;

public class java_12989_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter word to search:");
        String searchWord = scanner.nextLine();

        File directory = new File(directoryPath);

        File[] files = directory.listFiles((dir, name) -> name.contains(searchWord));

        if (files != null) {
            for (File file : files) {
                System.out.println("Found file: " + file.getName());
            }
        } else {
            System.out.println("No files found in the directory");
        }
    }
}