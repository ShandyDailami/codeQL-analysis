import java.io.File;
import java.util.Scanner;

public class java_18683_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String dirPath = scanner.nextLine();

        File directory = new File(dirPath);

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