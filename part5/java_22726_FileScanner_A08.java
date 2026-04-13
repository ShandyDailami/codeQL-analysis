import java.io.File;
import java.util.Scanner;

public class java_22726_FileScanner_A08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter the file extension:");
        String fileExtension = scanner.nextLine();

        File directory = new File(directoryPath);

        File[] textFiles = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

        if (textFiles != null) {
            for (File textFile : textFiles) {
                if (textFile.isFile()) {
                    System.out.println("Reading file: " + textFile.getName());
                    readFile(textFile);
                }
            }
        }

        scanner.close();
    }

    private static void readFile(File textFile) {
        try (Scanner fileScanner = new Scanner(textFile)) {
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Failed to read file: " + textFile.getName());
        }
    }
}