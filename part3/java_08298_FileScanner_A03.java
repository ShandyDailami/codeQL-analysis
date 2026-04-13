import java.io.File;
import java.util.Scanner;

public class java_08298_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        System.out.println("Enter the file extension (e.g. .txt):");
        String fileExtension = scanner.nextLine();

        File directory = new File(directoryPath);

        File[] matchingFiles = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

        if (matchingFiles != null) {
            for (File file : matchingFiles) {
                System.out.println(file.getAbsolutePath());
            }
        } else {
            System.out.println("No files found with the specified extension.");
        }
    }
}