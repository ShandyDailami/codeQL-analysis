import java.io.File;
import java.util.Scanner;

public class java_02517_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] textFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

        if (textFiles != null) {
            for (File textFile : textFiles) {
                System.out.println(textFile.getName());
            }
        } else {
            System.out.println("No text files found in the directory.");
        }
    }
}