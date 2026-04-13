import java.io.File;
import java.util.Scanner;

public class java_00834_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        File directory = new File(directoryPath);

        System.out.println("Enter the file extension to search:");
        String fileExtension = scanner.nextLine();

        File[] textFiles = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

        if (textFiles != null) {
            for (File textFile : textFiles) {
                if (textFile.isFile()) {
                    System.out.println("Found file: " + textFile.getAbsolutePath());
                }
            }
        } else {
            System.out.println("No text files found in the directory.");
        }
    }
}