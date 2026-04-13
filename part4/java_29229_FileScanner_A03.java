import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_29229_FileScanner_A03 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter the file extension:");
        String fileExtension = scanner.nextLine();
        System.out.println("Enter the word to filter out:");
        String filterWord = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

        if (files != null) {
            for (File file : files) {
                if (!file.getName().contains(filterWord)) {
                    System.out.println("File: " + file.getPath());
                }
            }
        }
    }
}