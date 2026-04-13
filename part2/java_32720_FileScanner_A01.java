import java.io.File;
import java.util.Scanner;

public class java_32720_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter the file extension:");
        String fileExtension = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] listOfFiles = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                System.out.println(file.getAbsolutePath());
            }
        } else {
            System.out.println("No files with the specified extension found in the directory.");
        }

        scanner.close();
    }
}