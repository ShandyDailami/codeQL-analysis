import java.io.File;
import java.util.Scanner;

public class java_12369_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        System.out.println("Enter the file extension:");
        String fileExtension = scanner.nextLine();

        File directory = new File(dirPath);
        File[] listOfFiles = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

        if (listOfFiles == null) {
            System.out.println("No files found with the extension: " + fileExtension);
        } else {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    System.out.println("File found: " + file.getName());
                }
            }
        }
    }
}