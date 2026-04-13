import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_38808_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter the file extension:");
        String fileExtension = scanner.nextLine();

        try {
            File dir = new File(directoryPath);
            File[] files = dir.listFiles((dir1, name) -> name.endsWith(fileExtension));

            if (files != null) {
                for (File file : files) {
                    System.out.println(file.getName());
                }
            } else {
                System.out.println("No files found with the given extension in the directory.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while scanning the directory.");
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}