import java.io.File;
import java.util.Scanner;

public class java_03427_FileScanner_A08 {
    private static final String USER_DIRECTORY = System.getProperty("user.dir");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();

        System.out.println("Enter file extension:");
        String fileExtension = scanner.nextLine();

        scanner.close();

        try {
            File directory = new File(directoryPath);
            File[] textFiles = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

            if (textFiles != null) {
                for (File file : textFiles) {
                    if (file.isFile()) {
                        System.out.println("File: " + file.getAbsolutePath());
                    }
                }
            } else {
                System.out.println("No .txt files found in directory.");
            }
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}