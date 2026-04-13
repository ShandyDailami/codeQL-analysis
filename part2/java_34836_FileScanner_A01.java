import java.io.File;
import java.util.Scanner;

public class java_34836_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter the file extension:");
        String fileExtension = scanner.nextLine();

        File directory = new File(directoryPath);

        File[] filesWithExtension = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

        if (filesWithExtension != null) {
            for (File file : filesWithExtension) {
                System.out.println(file.getAbsolutePath());
            }
        } else {
            System.out.println("No files found with the specified extension.");
        }

        scanner.close();
    }
}