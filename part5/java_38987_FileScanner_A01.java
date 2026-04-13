import java.io.File;
import java.util.Scanner;

public class java_38987_FileScanner_A01 {
    private static final String DIRECTORY = "C:\\Users\\John\\Downloads";
    private static final String EXTENSION = "txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] textFiles = directory.listFiles((dir, name) -> name.endsWith(EXTENSION));

            if (textFiles != null) {
                for (File textFile : textFiles) {
                    System.out.println("File name: " + textFile.getName());
                }
            } else {
                System.out.println("No text files found in the directory");
            }
        } else {
            System.out.println("Directory does not exist");
        }

        scanner.close();
    }
}